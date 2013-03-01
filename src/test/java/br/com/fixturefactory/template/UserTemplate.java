package br.com.fixturefactory.template;

import br.com.bfgex.Gender;
import br.com.fixturefactory.Fixture;
import br.com.fixturefactory.Rule;
import br.com.fixturefactory.loader.TemplateLoader;
import br.com.fixturefactory.model.User;

public class UserTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(User.class).addTemplate("anyValidUser", new Rule(){{
			add("name", name());
			add("login", random("login1", "login2"));
			add("password", "madona");
			add("gender", random(Gender.class));
			add("email", "${login}@gmail.com");
		}}
		).addTemplate("validFemaleUser", new Rule(){{
			add("name", name(Gender.FEMALE));
			add("login", "${name}");
			add("password", name(Gender.MALE));
			add("gender", Gender.FEMALE);
			add("email", "duck@gmail.com");
		}});
	}
}
