class Snake {
    private int[] posX;
    private int[] posY;
    private int longueur;
    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    private int largeur;
    private Direction direction;

    public Snake(int startX, int startY, int taille) {
        longueur = taille;
        largeur = taille;
        posX = new int[100];
        posY = new int[100];
        for (int i = 0; i < taille; i++) {
            posX[i] = startX - i * 40; 
            posY[i] = startY;
        }
        direction = Direction.RIGHT;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getPosX(int index) {
        return posX[index];
    }

    public int getPosY(int index) {
        return posY[index];
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        for (int i = longueur - 1; i > 0; i--) {
            posX[i] = posX[i - 1];
            posY[i] = posY[i - 1];
        }
        switch (direction) {
            case UP:
                posY[0] -= 40;
                break;
            case DOWN:
                posY[0] += 40;
                break;
            case LEFT:
                posX[0] -= 40;
                break;
            case RIGHT:
                posX[0] += 40;
                break;
        }
    }

    public void augmenterLongueur() {
        longueur++;
        posX[longueur - 1] = posX[longueur - 2];
        posY[longueur - 1] = posY[longueur - 2];
    }
}