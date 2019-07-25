# LineSort

Actual jar file:
https://drive.google.com/file/d/1MTvzSQZJe9cZIIoH69sZPej9k2vEPQom

Small program for sorting data (String, Integer) in files inside supplied directory.

You can create a jar file yourself or download actual version from link above.
Some examples:    
  
For integers ascending:
```console
java –jar sort-it.jar C:\in_dir\ --out-prefix=sorted_ --content-type=i --sort-mode=a
```
For integers descending:
```console
java –jar sort-it.jar C:\in_dir\ --out-prefix=sorted_ --content-type=i --sort-mode=d
```
For strings ascending:
```console
java –jar sort-it.jar C:\in_dir\ --out-prefix=sorted_ --content-type=s --sort-mode=a
```
For description of launch options:
```console
java –jar sort-it.jar --help
```
