//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("09779d90-44db-49af-acd7-9c67a6a8c84c")
public class ArbitrePatMat {
    //@objid ("d1dd9f36-5682-4daf-907b-7193cc3e3013")
    public boolean testCheckMate(Echiquier plat, int x, int y, String tour) {
        if(!this.testMat(plat, x, y, tour))
            return false;
                //PRENDS CHAQUES PIECES ET TESTE CHAQUES MOUVEMENTS POSSIBLE,
                //SI UN MOUVEMENT EST REALISABLE SANS QUE testMat() == true,
                //RETURN FALSE,
                //SINON, RETURN TRUE LORSQUE TOUT L'ECHIQUIER A ETE TESTER
        for(int i = 0; i<8;i++)
            for(int j = 0; j<8;j++) {
                ArrayList <Case> getCadriage()= new ArrayList();
                if(plat.getCadriage().get(i*8+j).getPiece() != null && plat.getCadriage().get(i*8+j).getPiece().getCouleur() == tour)
                    for(int i2 = 0; i2<8; i2++)
                        for(int j2 = 0; j2<8; j2++) {
                            if(plat.testerMouvement(tour, j, i, j2, i2)) {
                                if(plat.getCadriage().get(i*8+j).getPiece() instanceof Roi) {
                                    if(!this.testMat(plat, j2, i2, tour)) {
                                        return false;
                                    }
                                }
                                else {
                                    Piece testTemp = plat.getCadriage().get(i2*8+j2).getPiece();
                                    plat.getCadriage().get(i2*8+j2).setPiece(plat.getCadriage().get(i*8+j).getPiece());
                                    plat.getCadriage().get(i*8+j).supprimerPiece();
                                    if(!this.testMat(plat, x, y, tour)) {
                                         plat.getCadriage().get(i*8+j).setPiece(plat.getCadriage().get(i2*8+j2).getPiece());
                                         plat.getCadriage().get(i2*8+j2).setPiece(testTemp);
                                         System.out.println(i2+"la"+j2);
                                         return false;
                                     }
                                     plat.getCadriage().get(i*8+j).setPiece(plat.getCadriage().get(i2*8+j2).getPiece());
                                     plat.getCadriage().get(i2*8+j2).setPiece(testTemp);
                                   }

                            }

                    }
            }
        return true;
    }
    public ArrayList getCadriage(){
      ArrayList <Case> list = new ArrayList();
      for(int lig =0; i<8; i++){
          for (int col=0; col < 8; col++){
            list.add(this.plateau[lig][col]);
          }
      }    return list;
    }

    public boolean testPat(Echiquier plat, int x, int y, String tour) {
        //MAT SANS LE PREMIER TEST//
        for(int i = 0; i<8;i++)
            for(int j = 0; j<8;j++) {
                if(plat.getCadriage().get(i*8+j).getPiece() != null && plat.getCadriage().get(i*8+j).getPiece().getCouleur() == tour)
                    for(int i2 = 0; i2<8; i2++)
                        for(int j2 = 0; j2<8; j2++) {

                            if(plat.testerMouvement(tour, j, i, j2, i2)) {
                                if(plat.getCadriage().get(i*8+j).getPiece() instanceof Roi) {
                                    if(!this.testMat(plat, j2, i2, tour)) {
                                        return false;
                                    }
                                }
                                else {
                                    Piece testTemp = plat.getCadriage().get(i2*8+j2).getPiece();
                                    plat.getCadriage().get(i2*8+j2).setPiece(plat.getCadriage().get(i*8+j).getPiece());
                                    plat.getCadriage().get(i*8+j).supprimerPiece();
                                    if(!this.testMat(plat, x, y, tour)) {
                                        plat.getCadriage().get(i*8+j).setPiece(plat.getCadriage().get(i2*8+j2).getPiece());
                                        plat.getCadriage().get(i2*8+j2).setPiece(testTemp);
                                        return false;
                                    }
                                    plat.getCadriage().get(i*8+j).setPiece(plat.getCadriage().get(i2*8+j2).getPiece());
                                    plat.getCadriage().get(i2*8+j2).setPiece(testTemp);
                                }

                            }

                        }
                    }
        return true;
    }


    public boolean testMat(Echiquier plat, int x, int y, String tour) {
        if(testDangerRoiCauseCavalier(plat,x,y,tour))
            return true;
        if(testDangerRoiCauseDiagonales(plat,x,y,tour))
            return true;
        if(testDangerRoiCauseAxes(plat,x,y,tour))
            return true;
        return false;
    }


    public boolean testDangerRoiCauseCavalier(Echiquier plat, int x, int y, String tour) {
        Piece test;
        try{
            //Possibilité Cavalier Droite Haut//
            test = plat.getCadriage().get((y+1)*8+x+2).getPiece();
            if( test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try{
            //Possibilité Cavalier Droite Bas//
            test = plat.getCadriage().get((y-1)*8+x+2).getPiece();
            if( test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try {
            //Possibilité Cavalier Gauche Haut//
            test = plat.getCadriage().get((y+1)*8+x-2).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try {
            //Possibilité Cavalier Gauche Bas//
            test = plat.getCadriage().get((y-1)*8+x-2).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try {
            //Possibilité Cavalier Bas Gauche//
            test = plat.getCadriage().get((y+2)*8+x-1).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try {
            //Possibilité Cavalier Bas Droite//
            test = plat.getCadriage().get((y+2)*8+x+1).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}
        try {

            //Possibilité Cavalier Haut Gauche//
            test = plat.getCadriage().get((y-2)*8+x-1).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try {
            //Possibilité Cavalier Haut Droite//
            test = plat.getCadriage().get((y-2)*8+x+1).getPiece();
            if(test instanceof Cavalier && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}
        return false;
    }

    //@objid ("307fbd39-1c26-4d24-b857-7e08aa34d7d7")
    public boolean testDangerRoiCauseDiagonales(Echiquier plat, int x, int y, String tour) {
        int y1;
        int x1;
        boolean champLibre;
        Piece test = null;
            for( y1 = y+1, x1 = x+1, champLibre = false; !champLibre && y1<8 && x1<8; y1++, x1++) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Fou || test instanceof Dame )  && test.getCouleur() != tour) {
                    return true;
                }
                else if(test != null){

                    champLibre = true;}
            }

            for( y1 = y+1, x1 = x-1, champLibre = false; !champLibre && y1<8 && x1>-1; y1++, x1--) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Fou || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }

            for( y1 = y-1, x1 = x-1, champLibre = false; !champLibre && y1>-1 && x1>-1; y1--, x1--) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Fou || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }

            for( y1 = y-1, x1 = x+1, champLibre = false; !champLibre && y1>-1 && x1<8; y1--, x1++) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Fou || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }
        return false;
    }

    //@objid ("e62b90f8-fbfc-451a-9845-7ef4f08f4c4e")
    public boolean testDangerRoiCauseAxes(Echiquier plat, int x, int y, String tour) {
        int y1;
        int x1;
        boolean champLibre;
        Piece test = null;
            for( y1 = y+1, x1 = x, champLibre = false; !champLibre && y1<8; y1++) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Tour || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }

            for( y1 = y-1 , x1 = x, champLibre = false; !champLibre && y1>-1; y1--) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Tour || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }

            for( y1 = y , x1 = x+1, champLibre = false; !champLibre && x1<8; x1++) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Tour || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }

            for( y1 = y , x1 = x-1, champLibre = false; !champLibre && x1>-1; x1--) {
                test = plat.getCadriage().get(y1*8+x1).getPiece();
                if( (test instanceof Tour || test instanceof Dame )  && test.getCouleur() != tour)
                    return true;
                else if(test != null)
                    champLibre = true;
            }
        return false;
    }

    //@objid ("83119f55-07d5-4d1e-89a9-9de93a9e0461")
    public boolean testDangerRoiCausePion(Echiquier plat, int x, int y, String tour) {
        Piece test;
        try{
            //Possibilité Cavalier Droite Haut//
            test = plat.getCadriage().get((y+1)*8+x+1).getPiece();
            if( test instanceof Pion && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try{
            //Possibilité Cavalier Droite Haut//
            test = plat.getCadriage().get((y+1)*8+x-1).getPiece();
            if( test instanceof Pion && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try{
            //Possibilité Cavalier Droite Haut//
            test = plat.getCadriage().get((y-1)*8+x+1).getPiece();
            if( test instanceof Pion && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}

        try{
            //Possibilité Cavalier Droite Haut//
            test = plat.getCadriage().get((y-1)*8+x-1).getPiece();
            if( test instanceof Pion && test.getCouleur() != tour)
                return true;
        }catch(Exception e) {}
        return false;
    }

}
