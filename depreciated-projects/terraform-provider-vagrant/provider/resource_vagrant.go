
package provider;

import "os";
import "log";
import "fmt";
//import "bufio";
//import "errors";
import "os/exec";
import "github.com/hashicorp/terraform/helper/schema";

func resourceVagrant() *schema.Resource {
	return &schema.Resource{
		Exists: resourceVagrantExists,
		Create: resourceVagrantCreate,
		Read:   resourceVagrantRead,
		Update: resourceVagrantUpdate,
		Delete: resourceVagrantDelete,

		Schema: map[string]*schema.Schema{
			"name": &schema.Schema{
				Type:     schema.TypeString,
				Required: true,
			},
			"address": &schema.Schema{
				Type:     schema.TypeString,
				Required: true,
			},
		},
	}
}

func print(valor string) {
	fmt.Println(valor);
	log.Printf(valor);

	var commands string = "echo '" + valor + "' `date -u` >> $HOME/.terraform/file-date.txt";

	output, err := exec.Command("sh", "-c", commands).CombinedOutput();
	//output, err := exec.Command("bash", "-c", cmd).Output();
	if (err != nil) {
	  	os.Stderr.WriteString(err.Error());
	}
	fmt.Println(string(output));
}

func resourceVagrantExists(d *schema.ResourceData, meta interface{}) (bool, error) {
	print("[resourceVagrantExists]---------------------");

	return true, nil;
}

func resourceVagrantCreate(d *schema.ResourceData, meta interface{}) error {
	print("[resourceVagrantCreate]---------------------");

	address := d.Get("address").(string);
    d.SetId(address);

    return resourceVagrantRead(d, meta);
}

func resourceVagrantRead(d *schema.ResourceData, meta interface{}) error {
	print("[resourceVagrantRead]---------------------");

	return nil;
}

func resourceVagrantUpdate(d *schema.ResourceData, meta interface{}) error {
	print("[resourceVagrantUpdate]---------------------");

	// Enable partial state mode
	d.Partial(true);
	 
	if d.HasChange("address") {
		// Try updating the address
		//if err := updateAddress(d, m); err != nil {
		//	return err
		//}
		d.SetPartial("address");
	}
	// If we were to return here, before disabling partial mode below,
	// then only the "address" field would be saved.

	// We succeeded, disable partial mode. This causes Terraform to save
	// save all fields again.
	d.Partial(false);
	 
	return resourceVagrantRead(d, meta);
}

func resourceVagrantDelete(d *schema.ResourceData, meta interface{}) error {
	print("[resourceVagrantDelete]---------------------");

	// d.SetId("") is automatically called assuming delete returns no errors, but
	// it is added here for explicitness.
	d.SetId("");

	return nil;
}
