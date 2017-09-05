https://i3wm.org/ - tiling windows manager
nslookup
netstat
grep -rnw '/path/to/somewhere/' -e 'pattern'

grep Copy\ modules\ from $(find . -name *.mk)
./device/delphi/volvoihu/common/AndroidBoard-common.mk:	@echo Copy modules from $(LOCAL_KERNEL_PATH)/lib/modules/$$(cat $(LOCAL_KERNEL_PATH)/include/config/kernel.release) into $(PRODUCT_OUT)/$(KERNEL_MODULES_ROOT)


grep -rn --color=auto UT_DIR_COMMON_BASE build
build/core/envsetup.mk:286:ifeq (,$(strip $(OUT_DIR_COMMON_BASE)))
build/core/envsetup.mk:289:OUT_DIR := $(OUT_DIR_COMMON_BASE)/$(notdir $(PWD))
build/soong/soong_ui.bash:62:        if [ "${OUT_DIR_COMMON_BASE-}" ]; then
build/soong/soong_ui.bash:63:            out_dir="${OUT_DIR_COMMON_BASE}/$(basename ${TOP})"
build/soong/ui/build/config.go:56:		if baseDir, ok := ret.environ.Get("OUT_DIR_COMMON_BASE"); ok {
build/soong/ui/build/config.go:85:		"OUT_DIR_COMMON_BASE",


Linux console and commands
https://workaround.org/linuxtip/pipes


sudo mount -t tmpfs -o size=200G tmpfs /mnt/ramdisk

File permissions
----------------
https://www.linux.com/learn/understanding-linux-file-permissionss

Lägga till su rättigheter
sudo visudo

zcat - packar up gz filer och visar inneållet samtidigt