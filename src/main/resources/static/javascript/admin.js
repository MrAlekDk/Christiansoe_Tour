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

function createAttraction(evt){
    evt.preventDefault()
    evt.stopPropagation()
    const attraction = {}
    const URL2 ='http://localhost:8080/seværdigheder'
    attraction.name = document.getElementById("name").value
    attraction.description = document.getElementById("desc").value
    attraction.time = document.getElementById("time").value
    attraction.activeSeasonStart = document.getElementById("start").value
    attraction.activeSeasonEnd = document.getElementById("end").value
    attraction.photo = document.getElementById("pic").value
    attraction.sound = document.getElementById("sound").value
    let idValue = document.getElementById("location").value
    console.log(idValue)
    const options = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(attraction)
    };
    fetch(URL1 + "/" + idValue, options)
        .then(attraction => {
            fetchLocations()
            console.log(attraction)
            // remove create attraction modal
        }).catch(e => alert(e))
}

    document.getElementById("create-attraction").onclick = showAdminModal


    function showAdminModal(){
        const modal = document.getElementById("admin-modal")
        let span = document.getElementById("close")

        modal.style.display = "block"

        span.onclick = function (){
            modal.style.display = "none"
        }

        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none"
            }
        }

        document.getElementById("close-button").onclick = (e) => {
            modal.style.display = "none"
        }

    }

    document.getElementById("save-button").onclick = createAttraction



