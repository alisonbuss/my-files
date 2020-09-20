
package main;

import "github.com/hashicorp/terraform/plugin";
import "github.com/hashicorp/terraform/terraform";
import "./provider";

func main() {
	plugin.Serve(&plugin.ServeOpts{
		ProviderFunc: func() terraform.ResourceProvider {
			return provider.Provider();
		},
	});
}
