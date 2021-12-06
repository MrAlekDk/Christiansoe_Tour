// Kort bliver lavet. x-y koordinator og zoom sættes på. L for Leaflet.
const map = L.map('map').setView([55.3203, 15.1892], 16);

<!-- copyright til OpenStreetMap -->
const attribution =
    '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributers';

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
const oest = L.marker([55.32006234338913, 15.192730307766347]).addTo(map).bindTooltip("Danmarks østligste punkt");

<!-- Måle afstanden fra brugeren til skibet med leaflet -->
measuredDistance = user.getLatLng().distanceTo(ship.getLatLng());
document.getElementById("distance").innerHTML = measuredDistance.toFixed(0) + " Meter";

<!-- Timer -->
document.getElementById("startButton").onclick = (e) => {
    <!-- Opret dato for idag med den indtastede afgangstid -->
    let departTime = document.getElementById("depature").valueAsDate;
    let date = new Date()
    let today = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    let departureTime = (departTime.getHours()-1) + ':' + departTime.getMinutes() + ':' + departTime.getSeconds();
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
        if (hourDifference<10){
            hourDifference = "0" + hourDifference;
        }
        if (minuteDifference<10){
            minuteDifference = "0" + minuteDifference;
        }
        if (secondDifference<10){
            secondDifference = "0" + secondDifference;
        }

        document.getElementById("timer").innerHTML = hourDifference + ":" + minuteDifference + ":" + secondDifference;

        <!-- Meddelser til brugeren -->
        if (hourDifference==="00" && minuteDifference < 10) {
            document.getElementById("timer").innerHTML = "Båden sejler snart\n " + hourDifference + ":" + minuteDifference + ":" + secondDifference;
        }

        if (distance < 0) {
            clearInterval(x);
            document.getElementById("timer").innerHTML = "Båden har forladt havnen";
            map.removeLayer(ship)
        }
    }, 1000);

    //fetch locations
    const URL = "http://localhost:8080/lokationer";
    let locations = []

    function fetchLocations() {
        fetch(URL)
            .then(res => res.json())
            .then(data=> {
                locations = data
                console.log(data);
            })
    }

    fetchLocations()

    /*document.getElementById("map").addEventListener("click", function (){
         const idForLocationToFind = document.getElementById("location-id").value
     }*/


    /*const URL = "http://localhost:8080/location";
    document.getElementById("map").addEventListener("map") = (evt) => {
        evt.preventDefault()
        const idForLocationToFind = document.getElementById("location-id").value
        fetch(URL + "/" + idForUserToFind)
            .then(res => {
                if (res.status == 404) {
                    throw `Location with ID ${idForLocationToFind} not found`
                }
                return res.json()
            })
    }*/
}