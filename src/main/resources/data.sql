INSERT INTO locations(id,name,description,lat,long)
VALUES(1,'Danmarks østligste punkt','Lige her, befinder danmarks mest østliggende punkt sig!',55.32006234338913,15.192730307766347),
(2,'Hertugindens Bastion','En af bastionerne i den Nord-østlige del af Christiansø',55.32220804010796,15.190300179911),
(3,'Rantzaus Bastion','Historisk mindesmærke på Christiansø',55.32220804010796,15.190300179911),
(4,'Hestehytten','Hestehytten er en af øens soldaterhytter, som Christiansø Administration råder over til udlejning.',55.32248349511562,15.187628699732167),
(5,'Farhansylv','mangler tekst',55.32126968558762,15.18755896229778),
(6,'Christiansø Kirke','Christiansø Kirke - en lidt speciel Kirke, ligger i Christiansø Sogn.',55.321391964798615,15.186984969568593),
(7,'Store Tårn','Det tidligere fæstningsværk fra 1600-tallet, Store Tårn, har fået nyt liv - færdigt og klart til at tage imod beboere og besøgende på Christiansø i nye kunst- og samlingslokaler.',55.32063520112953,15.186979605150563),
(8,'Sirenehuset','Turistinformation, butik, lækker kaffe og smil på Christiansø.',55.32012871271153,15.186770392847402),
(9,'Kongens Bastion','På Christiansøs sydspids ligger Kongens Bastion – en af de større bastioner, der brugtes til forsvaret af søfæstningen Christiansø.',55.3180067325101,15.18806321759258),
(10,'Skibsplads','Her lægger skibbet til kajs',55.3180067325101,15.18806321759258),
(11,'Statsfængslet Ballonen','Fængslet er blevet kendt, fordi man i Danmark forviste politiske fanger og andre hertil – den mest kendte fange var nok Dr. Dampe, der sad her fra 1826-1841. Se cellen, hvor han sad.',55.31999784497225,15.184517337274892),
(12,'Badebro','Fra badebroen på Frederiksø kan du trygt hoppe i vandet og tage dig en forfriskende dukkert i Østersøen – “overvåget” af sælerne, der plejer at ligge lidt længere væk på en lille holm.',55.32129181414675,15.183439089250905),
(13,'Lille Tårn','Lille Tårn fremstår i dag, som det så ud på fæstningstiden, og danner rammen om et lokalt museum med en militærhistorisk og lokalhistorisk udstilling.',55.322085763414286,15.183739496660573),
(14,'Bielkes Batteri','Et sted med en masse kanoner',55.32050563588884,15.19156256225294),
(15,'Loppehytten','En lille hytte på Christiansø',55.319822683535484,15.191374807621898),
(16,'Blå Hane','Den Blå Hane, på sydøst siden af Christiansø, er en af de gamle soldaterhytter, som folk med tilknytning til Christiansø, de såkaldte hytte-boere - kan bebo sommeren over.',55.318392642398386,15.189733295704784),
(17,'Vestre Længe','Boliger for Øens beboer',55.319674645384445,15.186450271870555),
(18,'Pak huset','Restaurant',55.320148518137,15.186273246075572),
(19,'Christiansø Museum-øst','Det ene af de to museer',55.320585758019504,15.186922340657176),
(20,'Rugmarken','Et naturskønt område',55.32230491100849,15.188290267254771),
(21,'Christiansø teltplads','Her kan du campere',55.32180206838114,15.190259008671703),
(22,'Kanonbådsskurene','Her opbevarede man robåde med enkelte kanoner på',55.32007831512368,15.185200362469615),
(23,'Ruths Sild','Christiansøs bedste sild (og de eneste)',55.31981467117548,15.185251324440898),
(24,'Bådsmandsboden','Bådmændenes bod',55.322044715543946,15.184508352543773),
(25,'Christiansø Museum-vest','Det ene af de to museer',55.32204786307992,15.183754651);


INSERT INTO attractions (id,name,location_id)
VALUES
(1,'Test seværdighed til Danmarks østligste punkt',1),
(2,'Test seværdighed til Christiansø museum-vest',25);