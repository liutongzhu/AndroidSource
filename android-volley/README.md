mirror of volley library from android source

from : 
https://android.googlesource.com/platform/frameworks/volley

original:
git clone https://android.googlesource.com/platform/frameworks/volley

update weekly from android source repo
编译说明：
SDK目录和目录下的tools目录加入系统path里面，ant目录\bin也同样加入path：

cd volley
android update project -p .
ant jar

