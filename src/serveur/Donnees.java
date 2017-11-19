package serveur;

import java.util.Stack;


public class Donnees {

	private Stack<Objet> listeObjets = new Stack<Objet>();

	public Stack<Objet> getListeObjets() {
		return listeObjets;
	}

	public void setListeObjets(Stack<Objet> listeObjets) {
		this.listeObjets = listeObjets;
	}

	
	//TODO a virer par la suite
	public void initObjets(){
		Objet obj1 = new Objet("Botruc","Petite créature d'une vingtaine de centimètres ayant un aspect végétal et deux longs doigts pointus à chaque main. - Peut crocheter des serrures -", 400);
		Objet obj2 = new Objet("Cerbère nain","Chien géant à trois tête servant de gardien - Cet exemplaire est de petite taille -", 250);
		Objet obj3 = new Objet("Demiguise","Créature pouvant se rendre invisible lorsqu'elle est menacée. - Ses poils servent à tisser des toiles d'invisibilité -", 900);
		Objet obj4 = new Objet("Démonzémerveille","Créature apparaissant sous forme de boule et se transformant, quand on la lance, en oiseau de proie bleu et vert. - A un attrait particulier pour le cerveau humain -", 1000);
		Objet obj5 = new Objet("Éruptif","Sorte de Rhinocéros géant vivant en Afrique. Le fluide contenu dans sa corne peut être injecté dans tout type de materiau, provoquant l'explosion de celui-ci. - Sa peau épaisse le rend insensible à la plupart des sorts -", 600);
		Objet obj6 = new Objet("Plume d'Hippogriffe","L'hippogriffe est une créature volante mi-aigle, mi- cheval. Il est très dangereux tant qu'il n'est pas dressé. - Cette plume a été récoltée dans les alentours de Poudlard et mesure 50 cm -", 150);
		Objet obj7 = new Objet("Niffleur","Animal à la fourrure noire et au long museau semblable à un ornithorynque. Ils sont attirés par tout ce qui brille. - Formidable voleur -", 250);
		Objet obj8 = new Objet("OEuf d'Occamy","Les Occamy sont une sorte d'oiseau-serpent. Ils ont la particularité d'être choranaptyxique : leur taille varient en fonction de l'espace dont ils disposent. - La coquille des oeufs d'Occamy est en argent pur -", 700);
		Objet obj9 = new Objet("Oiseau-Tonnerre","Vivant en Arizona, ces oiseau provoquent des tempêtes lorsqu'ils se sentent menacés. - Leur plume peuvent être utilisées pour fabriquer des baguettes magiques", 1250);
		Objet obj10 = new Objet("OEuf congelé de Serpencendre","Les serpencendres naissent dans des feux magiques laissés sans surveillance. Ils se cachent dans des recoins de la maison pour y pondre leurs oeufs qui, s'ils réussissent à grandir sans être repérés et chassés, enflamment la maison.", 2000);
		
		listeObjets.push(obj1);
		listeObjets.push(obj2);
		listeObjets.push(obj3);
		listeObjets.push(obj4);
		listeObjets.push(obj5);
		listeObjets.push(obj6);
		listeObjets.push(obj7);
		listeObjets.push(obj8);
		listeObjets.push(obj9);
		listeObjets.push(obj10);
	}
	
	
	
	
	/**
	 * Methode permettant l'ajout d'un nouvel objet aux enchere. Ajoute l'objet dans la liste des objets a vendre.
	 * @param objet l'objet a vendre.
	 * @throws Exception so l'objet est deja en vente ou si l'acheteur n'est pas encore inscrit.
	 */
	public void ajouterArticle(Objet objet) throws Exception{
		for(Objet each : this.listeObjets){
			if(each.equals(objet)){
				throw new Exception("Objet deja existant");
			}
		}

		this.listeObjets.add(objet);
	}
	
	
}
