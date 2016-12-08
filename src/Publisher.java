import org.ros.node.NodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.DefaultNodeMainExecutor;
import java.net.URI;

public class Publisher {
	public static void main(String[] args) {
		NodeMainExecutor nodeMainExecutor = DefaultNodeMainExecutor.newDefault();
		Talker publisherNode = new Talker();
		String host = "127.0.0.1";
	    URI masteruri = URI.create("http://"+host+":11311");
	    NodeConfiguration pubNodeConfiguration = NodeConfiguration.newPublic(host, masteruri);
	    nodeMainExecutor.execute(publisherNode, pubNodeConfiguration);   	
	}
}
