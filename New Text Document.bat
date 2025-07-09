cd /D "E:\Users\jacob 2\Documents\BTD6 Mod Sources\DruidSurv-SlayTheSpire\target\classes\"

"E:\Program Files\7-Zip\7z" a drid.jar druidsurv\
"E:\Program Files\7-Zip\7z" a drid.jar druidsurvResources\
"E:\Program Files\7-Zip\7z" a drid.jar ModTheSpire.json

echo "copy /y drid.jar ^"E:\Program Files (x86)\Steam\steamapps\common\SlayTheSpire\mods\^""
copy /y drid.jar "E:\Program Files (x86)\Steam\steamapps\workshop\content\646570\1605060445\mods\"

cd /D "E:\Program Files (x86)\Steam\steamapps\workshop\content\646570\1605060445\"
"E:\Program Files (x86)\Steam\steamapps\common\SlayTheSpire\jre\bin\java.exe" -jar ModTheSpire.jar

