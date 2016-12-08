import org.ros.concurrent.CancellableLoop;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;


public class Talker extends AbstractNodeMain {
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("ROSJavaIC/talker");
	}
	@Override
	public void onStart(final ConnectedNode connectedNode) {
		final Publisher<std_msgs.String> publisher = connectedNode.newPublisher("testtopic", std_msgs.String._TYPE);
		connectedNode.executeCancellableLoop(new CancellableLoop() {
			@Override
			protected void loop() throws InterruptedException {
				std_msgs.String str = publisher.newMessage();
				str.setData("PubTest");
				publisher.publish(str);
				Thread.sleep(1000);
			}
		});
	}
}
