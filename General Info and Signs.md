**Path that classes are dropped to:**
%appdata%/Local/Adobe, you should not have ANY classes here.

**Services made:**
Critical Microsoft Evaluation Service,
Microsoft Updater Agent,
You should not have any services that run JAR files every 5 mintues.

**Infections:**
If you use the normal minecraft directory (%appdata%/.minecraft)
All your jars inside of your mod folder will be injected with a rat class named OgreBeard.class. You can check all jars in a certain directory for this using [CheckForInfectedJars.java](https://github.com/CadeCodes/Cleanse/blob/main/CheckForInfectedJars.java)

Also, your jsons are modified, However, I am not sure how they are ratted yet (There is no special libraries or anything, only changes i found was releaseTime)

**To Fix/ Be Safe:**
If possible, a full reset is always safest.
If not possible, delete all files mentioned here, all services, etc. Add firewall rules blocking domains within HostsMod (as of the most recent commit - 2.0.1) as well as actually run [HostsMod](https://github.com/GardeningTool/HostsMod)
