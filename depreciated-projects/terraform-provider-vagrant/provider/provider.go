
package provider;

import "os";
import "fmt";
import "log";
import "github.com/hashicorp/terraform/helper/schema";

func init() {
	// Terraform is already adding the timestamp for us
	log.SetFlags(log.Lshortfile);
	log.SetPrefix(fmt.Sprintf("pid-%d-", os.Getpid()));
}

func Provider() *schema.Provider {
	return &schema.Provider{
		ResourcesMap: map[string]*schema.Resource{
			"vagrant_instance": resourceVagrant(),
		},
	}
}
