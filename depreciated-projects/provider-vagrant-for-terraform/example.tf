

resource "vagrant_instance" "coreos" {
    count = 1
    name = "${format("coreos-%02d", count.index+1)}"
    address = "127.0.0.${count.index+1}"
}






















