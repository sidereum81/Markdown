adb shell top -m 10
adb shell cat /proc/uptime
adb shell uptime

https://source.android.com/source/add-device
http://mmmyddd.github.io/wiki/android/overlay.html

https://sites.google.com/a/google.com/android-eap/pdk/sync-and-download#TOC-Access-Control
https://support.google.com/androidpartners_androidautomotive/answer/7326639
https://partner-android-review.googlesource.com/#/settings/http-password
https://www.googlesource.com/new-password?state=partner-android&code=4/dA0VVFmol8-NEqPAwm43iYXqzeOv98CRsh_jUajM9c4#


sudo mkdir /mnt/ramdisk
sudo mount -t tmpfs -o size=200G tmpfs /mnt/ramdisk
mkdir /mnt/ramdisk/test

export USE_CCACHE=1
export CCACHE_DIR=/mnt/ramdisk/.ccache
prebuilts/misc/linux-x86/ccache/ccache -M 50G

export OUT_DIR_COMMON_BASE=/mnt/ramdisk/test

source build/envsetup.sh
lunch ihu_vcc-eng