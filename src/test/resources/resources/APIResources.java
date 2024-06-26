package resources;

public enum APIResources {

		PlaceOrderAPI("/api/Order"),
		GetOrderAPI("/api/Order/{Order}"),
		DeleteOrderAPI("/api/Order/{Order}"),
		PutOrderAPI("/api/Order/{Order}");
		private String resource;

		APIResources(String resource)
		{
			this.resource=resource;
		}
		
		public String getResource()
		{
			return resource;
		}
}
