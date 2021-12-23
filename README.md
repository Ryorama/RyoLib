# RyoLib

RyoLib is a library which is used in all my mods for the FabricMC modloader. A list of mods that currently use the library are:
## TerrariaMod
### https://www.curseforge.com/minecraft/mc-mods/ryoramas-terraria-mod
### https://github.com/Ryorama/Terrariamod

For use in your own mod, add this to your build.gradle file

```
repositories {
   maven {
      url = uri("https://raw.github.com/Ryorama/maven/master")
   }
}

dependencies {
    modImplementation "com.ryorama:ryolib:${ryolib_version}"
}
```

and add this to your gradle.properties file (make sure to replace "1.0.0" with the version you want to use)
```
ryolib_version = 1.0.0
```
