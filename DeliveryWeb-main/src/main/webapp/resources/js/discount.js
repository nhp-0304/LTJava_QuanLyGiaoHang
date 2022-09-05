/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function getDiscounts(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myDiscount");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += ` 
                <tr id="row${data[i].id}">
                    <td>${data[i].discountName}</td>
                    <td>${data[i].discountPercent}</td>
                    <td>
                        <button class="btn btn-light">Sửa</button>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteDiscount('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }

        let d2 = document.getElementById("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}

function deleteDiscount(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}