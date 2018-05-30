package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
	private String text;
    @NotNull
	private String heading;

}
