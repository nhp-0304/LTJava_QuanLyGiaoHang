/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function loadFeedbacks(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("feedbacks");
        let h = '';
        for (let d of data)
            h += `
                <li class="list-group-item"><em>${d.comment}</em> được bình luận bởi <strong>${d.customer.id}</strong> vào lúc <strong>${moment(d.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        c.innerHTML = h;
    });
}

function addFeedback(endpoint, shipperId) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "comment": document.getElementById("commentId").value,
            "shipperId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json
    }).then(function (data) {
        let d = document.querySelector("#comments li:first-child");
        let h = `
                <li class="list-group-item"><em>${data.comment}</em> duoc binh luan boi <strong>${data.id}</strong> vao luc <strong>${moment(data.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        d.insertAdjacentHTML("beforebegin", h);
    });
}
