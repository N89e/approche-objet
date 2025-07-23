package fr.diginamic.combat;

/**
 * Classe abstraite représentant une potion
 */
public abstract class Potion {

    public abstract void utiliser(Personnage personnage);

    /**
     * Cette potion peut-elle être consommée uniquement entre 2 combats ?
     * Ex : potion de soin oui, potion attaque non.
     * @return vrai si consommable entre combats
     */
    public abstract boolean estUtilisableEntreCombats();

    @Override
    public abstract String toString();
}
