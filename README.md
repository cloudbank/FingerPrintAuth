# FingerPrintAuth

<img src="http://i.imgur.com/pJJ3WT8.png">fingerprint emulation</img>


1) Setting up the emulator, running a minimum of M (23) :

Settings> Security> ( pattern if enabled) > Fingerprint
+ add fingerprint
./adb devices to get emulator id --> emulator-5554

 ./adb -s emulator-5554 emu finger touch 1
 
 to add a new fingerprint where 1 is the id
 
 2) When you touch the authenticate button, it says
 "Swipe finger'
 you need to send the fingerprint with id that you set up via:
 ./adb -s emulator-5554 emu finger touch 1
 and you should get 
 "auth ok"
 
 






