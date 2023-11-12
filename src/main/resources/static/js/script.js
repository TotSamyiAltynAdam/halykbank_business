function signIn() {
    let login = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET",`http://localhost:8081/api/v1/login/${login}/${password}`,true);
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState===XMLHttpRequest.DONE && httpRequest.status===200){
            let answer = JSON.parse(httpRequest.responseText);

            if (answer['status'] === "true") window.open("profile")
            else alert("Don't correct password")

        }
    };
    httpRequest.send();
}

function getOrganizations() {

    let div = document.getElementsByName("orga")
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET",`/api/v1/organization`,true);
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState===XMLHttpRequest.DONE && httpRequest.status===200){
            let answer = JSON.parse(httpRequest.responseText);
            let content = "";
            for(let i = 0;i < answer.length;i++) {
                let name = answer[i].name;
                let address = answer[i].address;
                console.log(name + " " + address);
                content += "<a th:href=\"@{/api/v1/receipt\"><p class=\"organization\">" + name + " " + address +"</p></a>\n";
            }
            console.log(div);
            console.log(content);
            div.insertAdjacentElement(content);

        }
        console.log(div)
    };
    httpRequest.send();
}
getOrganizations();


function getReceipts() {
    let div = document.getElementById("show-receipts")
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET",`/api/v1/receipt`,true);
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState===XMLHttpRequest.DONE && httpRequest.status===200){
            let answer = JSON.parse(httpRequest.responseText);
            let content = "";
            for(let i = 0;i < answer.length;i++) {
                let phoneOfClient = answer[i].phone_number;
                let price = answer[i].totalPrice;
                content += "<div class=\"field_item2\">\n" +
                    "                <img th:src=\"@{./img/icons/man.svg}\" alt=\"\">\n" +
                    "                <div class=\"item_wrap\">\n" +
                    "                    <div class=\"wrap_text\">Halyk Bank</div>\n" +
                    "                    <div class=\"wrap_card\"><img th:src=\"@{./img/icons/arrow.png}\" alt=\"\">"+phoneOfClient+"</div>\n" +
                    "                </div>\n" +
                    "                <div class=\"item_money\">\n" +
                    "                    "+price+" <img th:src=\"@{./img/icons/tenge.svg}\" alt=\"\">\n" +
                    "                </div>\n" +
                    "            </div>\n";
            }
            div.append(content);

        }
    };
    httpRequest.send();
    // <div class="field_item2">
    //     <img th:src="@{./img/icons/man.svg}" alt="">
    //         <div class="item_wrap">
    //             <div class="wrap_text">Halyk Bank</div>
    //             <div class="wrap_card"><img th:src="@{./img/icons/arrow.png}" alt="">Айдар К.</div>
    //         </div>
    //         <div class="item_money">
    //             300.00 <img th:src="@{./img/icons/tenge.svg}" alt="">
    //         </div>
    // </div>
}
