// Kort bliver lavet. x-y koordinator og zoom sættes på. L for Leaflet.
const map = L.map('map').setView([55.3203, 15.1892], 16);

<!-- copyright til OpenStreetMap -->
const attribution =
    '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';

<!-- Tilføje tiles til vores map -->
const tileURL = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileURL, { attribution });
tiles.addTo(map);

<!-- Icons til markers -->
var shipIcon = L.icon({
    iconUrl: "https://www.freeiconspng.com/uploads/ship-travel-cruise-tourism-travel-icon-png-ship-png-ship-icon-29.png",
    iconSize: [50,32],
    iconAnchor: [25,16]
});

var userIcon = L.icon({
    iconUrl: "https://www.freeiconspng.com/uploads/person-icon-person-icon-clipart-image-from-our-icon-clipart-category--9.png",
    iconSize: [40,40],
    iconAnchor: [25,16]
});

<!-- Tilføje markers til kortet -->
const ship = L.marker([55.32073, 15.18600], {icon: shipIcon}).addTo(map).bindTooltip("Ship");
const user = L.marker([55.3230, 15.1880], {icon: userIcon}).addTo(map).bindTooltip("You");

    <!-- Måle afstanden fra brugeren til skibet med leaflet -->
    function measuredDistance(){
        distance = user.getLatLng().distanceTo(ship.getLatLng());
        document.getElementById("distance").innerHTML = distance.toFixed(0) + " Meter";
    }

    <!-- Timer -->
    document.getElementById("startButton").onclick = (e) => {
    <!-- Opret dato for idag med den indtastede afgangstid -->
    let departTime = document.getElementById("depature").valueAsDate;
    let date = new Date()
    let today = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
    let departureTime = (departTime.getHours() - 1) + ':' + departTime.getMinutes() + ':' + departTime.getSeconds();
    let timeLeft = today + " " + departureTime;
    let timer = new Date(timeLeft)

    document.getElementById("startButton").remove();

    let x = setInterval(function () {
        let timeNow = new Date();
        let distance = timer - timeNow;
        <!-- Udregning af tidsforskellen -->
        let hourDifference = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        let minuteDifference = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        let secondDifference = Math.floor((distance % (1000 * 60)) / 1000);
        <!-- Design logik -->
        if (hourDifference < 10) {
            hourDifference = "0" + hourDifference;
        }
        if (minuteDifference < 10) {
            minuteDifference = "0" + minuteDifference;
        }
        if (secondDifference < 10) {
            secondDifference = "0" + secondDifference;
        }

        document.getElementById("timer").innerHTML = hourDifference + ":" + minuteDifference + ":" + secondDifference;

        <!-- Meddelser til brugeren -->
        if (hourDifference === "00" && minuteDifference < 10) {
            document.getElementById("timer").innerHTML = "Båden sejler snart\n " + hourDifference + ":" + minuteDifference + ":" + secondDifference;
        }

        if (distance < 0) {
            clearInterval(x);
            document.getElementById("timer").innerHTML = "Båden har forladt havnen";
            map.removeLayer(ship)
        }
    }, 1000);
}

    //fetch locations
    const URL = "http://localhost:8080/lokationer";
    let locations = []

    function fetchLocations() {
        fetch(URL)
            .then(res => res.json())
            .then(data=> {
                locations = data
                createMarkers()
                setUserLocation(user, locations[4])
                console.log(data);
            })
    }

    fetchLocations()

    // Tilføje markers til kortet

    function createMarkers(){
        let markers = locations
        for (let i = 0; i < markers.length; i++) {
            let x = markers[i].coordinates.x;
            let y = markers[i].coordinates.y;
            let name = markers[i].name;
            let id = markers[i].locationID;

            let marker = L.marker([x , y]).on('click', clickLocationHandler).addTo(map).bindTooltip(name)
            marker.myVeryOwnId = id
        }
    }
    // Set test brugers lokation
    function setUserLocation(user, location){
        user.setLatLng([location.coordinates.x, location.coordinates.y])
        measuredDistance()
    }

// Tjek om der er hul igennem til geolocation
if ('geolocation' in navigator) {
    //console.log('geolocation is available')
    // setInterval(function (){
    navigator.geolocation.getCurrentPosition(position => {
        L.marker([position.coords.latitude, position.coords.longitude], {icon: userIcon}).addTo(map).bindTooltip("You");
    })
    // }, 1000)

    } else{
        console.log('geolocation is not available')
    }

    //Making a modal out of HTML element

//tell the modal where to put the data and what data (tell HTML)
function makeAttractionRows(map) {
    const rows = map.map(att => `
         <tr>
           <td>${att.name}</td>
           <td>${att.description.slice(0,90) + "..."}</td>
           <td><img src="${att.photo}" style="max-width: 200px"></td>
         </tr>
        `)
    let headerRows = ` <tr>
                    <th>Attraction name</th>
                    <th>Info</th>
                    <th>Picture</th>
                    </tr>`
    document.getElementById("table-head").innerHTML = headerRows
    document.getElementById("attraction-table-body").innerHTML = rows.join("")
}


    //Making a modal out of HTML element
    //const attractionModal = new bootstrap.Modal(document.getElementById('attraction-modal'))

//Finding the right attractions to show, due to what location the user press on + showing the modal when the user press a location in the map
function clickLocationHandler(event) {
    let locationId = event.target.myVeryOwnId
    let clickedLocation = locations.find(arr => arr.locationID === locationId)
    let specificAttractionsList = clickedLocation.attractionList

    makeAttractionRows(specificAttractionsList)
    showModal(locationId)
}

//Method that shows the modal
function showModal(locationId) {
    const modal = document.getElementById("myModal");
    let span = document.getElementsByClassName("close")[0];
    if(locationId!=null){
        document.getElementById("modal-title").innerText = locations[locationId - 1].name
    }

    modal.style.display = "block";

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    document.getElementById("btn-close").onclick = (e) => {
        modal.style.display = "none";
    }
}

function setUpHandlers() {
    document.getElementById("get-specific-route").onclick = getPossibleRoutes
}

//fetch routes
const URL1 = "http://localhost:8080/ruter";
let routes = []

function fetchRoutes() {
    fetch(URL1)
        .then(res => res.json())
        .then(data=> {
            routes = data
            console.log(data);
        })
}

fetchRoutes()

setUpHandlers()

function getPossibleRoutes(evt) {
    evt.preventDefault()
    evt.stopPropagation()
    routes = {}
    let userInterest = document.getElementById("interests").value
    let userDepatureTime = document.getElementById("depature").value

    //Figure out how to update local data
    const url = URL1 + '/specifikRuter/?userInterest=' + userInterest + '&userDepatureTime=' + userDepatureTime

    fetch(url)
        .then(res => res.json())
        .then(routes => {
            makeRoutesRows(routes)
            showModal()
        })
}

function makeRoutesRows(routes) {
    const rows = routes.map(route => `
         <tr>
           <td>${route.name}</td>
           <td>${route.interest}</td>
           <td>${route.routeLength}</td>
           <td>${route.timeDuration}</td>
         </tr>
        `)
    let headerRows = ` <tr>
                    <th>Route Name</th>
                    <th>Route interest</th>
                    <th>Route length</th>
                    <th>Route TimeDuration</th>
                    </tr>`
    document.getElementById("attraction-table-body").innerHTML = rows.join("")
    document.getElementById("table-head").innerHTML = headerRows
}







