package fulcrum.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Plugin {
	@Retention(RetentionPolicy.RUNTIME)
	@interface Registry {
		@Retention(RetentionPolicy.RUNTIME)
		@interface Item { }
		@Retention(RetentionPolicy.RUNTIME)
		@interface Block { }
		@Retention(RetentionPolicy.RUNTIME)
		@interface Recipe { }
	}
}
