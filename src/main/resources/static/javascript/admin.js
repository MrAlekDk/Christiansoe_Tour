const URL1 = "http://localhost:8080/seværdigheder";
let attractions = []

function fetchAttractions() {
    fetch(URL1)
        .then(res => res.json())
        .then(data => {
            attractions = data
            console.log(data)
            makeAttractionRows(attractions)
        })
}

fetchAttractions()

function makeAttractionRows(att) {
    const rows = att.map(att => `
         <tr>
           <td>${att.attraction_id}</td>
           <td>${att.name}</td>
           <td>${att.description}</td>
           <td>${att.activeSeasonStart}</td>
           <td>${att.activeSeasonEnd}</td>
           <td>${att.photo}</td>
           <td>${att.sound}</td>
           <td>${att.time}</td>
         </tr>
        `)
    let headerRows = ` <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Active Season start</th>
                    <th>Active Season end</th>
                    <th>Photo link</th>
                    <th>Sound link</th>
                    <th>Time</th>
                    </tr>`
    document.getElementById("attraction-table-body").innerHTML = rows.join("")
    document.getElementById("table-head-attraction").innerHTML = headerRows
}