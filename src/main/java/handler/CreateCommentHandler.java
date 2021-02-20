package handler;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreateCommentHandler implements EventHandler {

	@Inject
	public CreateCommentHandler() {
		System.out.println("Create comment handler");
	}

	public String handle(String value) {
		return value + "handled by create comment";
	}
}
