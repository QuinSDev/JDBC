package tienda.services;

import java.util.Scanner;
import tienda.entidades.Maker;
import tienda.persistencia.MakerDAO;

public class MakerService {

    private MakerDAO mDao;
    Maker maker;
    Scanner read = new Scanner(System.in);

    public MakerService() {
       mDao = new MakerDAO();
    }

    public void createMaker() throws Exception {

        do {
            try {
                maker = new Maker();
                System.out.print("\nEnter the maker name: ");
                maker.setName(read.nextLine());

                if (maker.getName() == null || maker.getName().isEmpty()) {
                    throw new IllegalArgumentException("You must indicate the name");
                }
                
                mDao.saveMaker(maker);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (maker.getName() == null || maker.getName().isEmpty());

    }

}
