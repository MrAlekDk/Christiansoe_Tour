INSERT INTO locations(id,name,description,lat,long)
VALUES
(1,'Danmarks østligste punkt','Lige her, befinder danmarks mest østliggende punkt sig!',55.32006234338913,15.192730307766347),
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


INSERT INTO attractions (id,name,description,time,ass,ase,photo,sound,location_id)
VALUES
(1,'Liderlige grønne frøer', 'Her på det østligste punkt kan man se mange dyr. Mest højlydt er grøn frø, men de er så hurtige til at smutte væk, at de sjældent ses. I denne måned er det dog muligt da det er grøn frø yngletid og de derfor er mere fremme',
 25, '2021-05-06', '2021-06-06', 'https://www.christiansoe.dk/wp-content/uploads/2018/11/animals.jpg', '/test/path/sound', 20),
(2,'Christiansø hest', 'Kom ind i hestehytten og hils på de søde heste her på Christionsø. Her kan du få lov at fodre og ae det store heste, og mellem kl. 10-15, er der mulighed for de mindste at ridde i ringe.',
 30, '2021-05-01', '2021-08-20', 'https://cdn.pixabay.com/photo/2017/04/02/19/12/horse-2196656__480.jpg', '/test/path/sound', 20),
(3,'Kunst og kultur', 'I 2018 blev Christiansø Kunst og Kulturråd oprettet.
Baggrunden var, at der med Store Tårns restaurering var behov for et rådgivende organ med kulturel og kunstnerisk ekspertise, der kunne sikre, at udstillingerne i de to tårne – faste såvel som skiftende – har et højt kunstnerisk og formidlingsmæssigt niveau.',
 20, '2021-03-07', '2021-09-02', 'https://www.christiansoe.dk/wp-content/uploads/2019/07/store-taarn-janne-klerk-3-1024x768.jpg', '/test/path/sound', 7),
(4,'Store tårn - store is', 'Så skete det. Den omvandrende is-bod har nået sit stop ved store tårn! Kom og få øens billigste og største is! Du kan også få en islatte, sodavand eller cafe til din dejlige vandre tur på Christiansø',
 10, '2021-05-06', '2021-08-14', 'https://p0.pikist.com/photos/471/30/ice-cream-man-ice-cream-shop-ice-cream-parlor-walking-ice-cream-cones-bicycle.jpg', '/test/path/sound', 7),
(5,'Gyldenløves Batteri historie', 'Gyldenløves Batteri blev bygget i sommeren 1684 og er fæstningens første bygningsværk. Batteriet er et af de fire havnebatterier (foruden Juels, Spanns og Sehesteds Batterier), som skulle forsvare havneindløbet mod en invaderende flåde. En af Christiansøs befæstningsmæssige svagheder var nemlig, at en fjende i princippet kunne omgå øernes mange kanonbatterier og fæstningstårne ved at sejle direkte gennem havneindløbet, ind i fæstningens hjerte. Derfor var havnen i krigstid spærret af kabler og kæder. Neden for Gyldenløves Batteri kan I se et hul i muren, hvorigennem havnespærringen var fastgjort.',
 35, '2021-05-06', '2021-09-02', 'https://www.christiansoe.dk/wp-content/uploads/2019/07/gyldenloeves-bastion-4-1024x511.jpg', '/test/path/sound', 4),
(6,'Edderfugle', 'Lige nu har Edderfuglenes yngletid her på Christianø. Edderfuglene lever mest af blåmuslinger. Kort efter edderfugleællingerne er klækket, svømmer de i småflokke sammen med hunnerne til Bornholm, hvor der er mere mad til ungerne i form af tanglopper og småmuslinger.',
 22, '2021-04-01', '2021-09-02', 'https://www.christiansoe.dk/wp-content/uploads/2018/12/aabo-2-1024x680.jpg', '/test/path/sound', 16),
(7,'Ynglefuglene på Christiansø', 'De fleste af ynglefuglene er hav- og kystfugle, fx alk, lomvie, sølvmåge og edderfugl. Alk og lomvie er ægte havfugle, der kun kommer på land i yngletiden. Normalt holder de kun til på ',
 23, '2021-05-06', '2021-09-02', 'https://www.christiansoe.dk/wp-content/uploads/2018/11/fugl7457.jpg', '/test/path/sound', 16),
(8,'Øl-smagning', 'Kom til ølsmagning på', 10, '2021-05-06', '2021-09-02', '/test/path/picture', '/test/path/sound', 18),
(9,'Sæler', 'Her finder du Danmarks frækkeste sæler', 10, '2021-01-06', '2021-12-02', '/test/path/picture', '/test/path/sound', 1),
(10,'Udsigt over havet', 'Her finder du en af Christiansøs bedste udsigter', 10, '2021-01-06', '2021-12-02', '/test/path/picture', '/test/path/sound', 2),
(11,'Kanon med kanoner', 'Her finder du en række af Christiansøs forsvar, i form af gode gamledavs kanoner', 10, '2021-01-06', '2021-12-02', '/test/path/picture', '/test/path/sound', 3),
(12,'Spøgelser og andre myter', 'Det spøger på christiansø, kom og hør om christiansøs helt eget spøgelse ved farhansylv', 10, '2021-08-06', '2021-08-02', '/test/path/picture', '/test/path/sound', 5),
(13,'Vinsmagning i Jesus tegn', 'Af jord er du kommet og af jord skal du blive. Eller, det bliver du i hvertfald efter du har fået en lille en her i guds hus. Vel mødt!', 10, '2021-05-06', '2021-06-02', '/test/path/picture', '/test/path/sound', 6),
(14,'Hør sirener i sirenehuset', 'Kommer du forbi her, bliver du nok lidt døv. Det bliver hyggeligt', 10, '2021-05-06', '2021-09-02', '/test/path/picture', '/test/path/sound', 8);

