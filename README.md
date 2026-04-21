# Building
Doing `gradlew build` will build a universal jar that runs on Fabric and NeoForge.

# Running
There should be generated run configurations to run the mod.

# What to look for
In the creative inventory, there is a new block, it is tinted orange.

It should look orange when placed, it has no item model. (WORKS from my testing)

There is also a block rendered at `0 200 0` by `Sodiumissue2590Client#collectSubmits`. It appears to be ORANGE when Sodium isn't installed and BLUE when it is.