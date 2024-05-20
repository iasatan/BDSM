package uni.miskolc.swgyak.bdsm.model.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dvds")
@Data //lombok, getters, setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dvd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;
    private String genre;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;
    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + releaseYear + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
