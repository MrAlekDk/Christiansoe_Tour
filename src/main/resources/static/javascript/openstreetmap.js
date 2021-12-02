// Kort bliver lavet. x-y koordinator og zoom sættes på. L for Leaflet.
const map = L.map('map').setView([55.3203, 15.1892], 15);

<!-- copyright til OpenStreetMap -->
const attribution =
    '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributers';

const tileURL = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileURL, { attribution });
tiles.addTo(map);
L.marker([55.3203, 15.1892]).addTo(map)
