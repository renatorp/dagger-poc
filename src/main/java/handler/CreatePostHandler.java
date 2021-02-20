package handler;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreatePostHandler implements EventHandler {

	@Inject
	public CreatePostHandler() {
		System.out.println("Create post handler");
	}

	public String handle(String value) {
		return value + "handled by create post";
	}
}
