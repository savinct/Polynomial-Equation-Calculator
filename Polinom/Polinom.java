
import java.util.ArrayList;

public class Polinom {

	private ArrayList<Monom> expresie = new ArrayList<Monom>();

	public Polinom() {
	}

	public void setPolinom(ArrayList<Monom> expresie) {

		this.expresie = expresie;

	}

	public ArrayList<Monom> getPolinom() {
		return expresie;
	}

	public void citirePolinom(String polinom1) {

		String gg = polinom1.replace("-", "+-");
		String[] nume = gg.split("\\+");
		String coef;
		String exp;

		for (int i = 0; i < nume.length; i++) {
			String[] b = nume[i].split("x");
			String[] a = b[1].split("\\^");

			coef = b[0];
			exp = a[1];
			Monom mon = new Monom(Float.parseFloat(coef), Integer.parseInt(exp));
			expresie.add(mon);

		}

	}

	public String afisarePolinom() {

		String a = "";

		for (int i = 0; i < expresie.size(); i++) {

			if (expresie.get(i).getCoeficient() != 0) {

				if (expresie.get(i).getCoeficient() >= 0) {

					a += "+";
					a = a + expresie.get(i).getCoeficient() + "x^" + expresie.get(i).getGrad();
				} else if (expresie.get(i).getCoeficient() < 0)
					a = a + expresie.get(i).getCoeficient() + "x^" + expresie.get(i).getGrad();

			}
		}

		if (a == "")
			a = "0";

		return a;

	}

	public Polinom polinomAdunare(Polinom p2) {

		Monom mon;
		int i = 0, j = 0;
		float coef;
		ArrayList<Monom> rez = new ArrayList<Monom>();

		while (i < this.expresie.size() && j < p2.expresie.size()) {

			if (this.expresie.get(i).getGrad() == p2.expresie.get(j).getGrad()) {

				coef = this.expresie.get(i).getCoeficient() + p2.expresie.get(j).getCoeficient();
				mon = new Monom(coef, this.expresie.get(i).getGrad());

				rez.add(mon);
				j++;
				i++;
			} else if (this.expresie.get(i).getGrad() > p2.expresie.get(j).getGrad()) {

				mon = new Monom(this.expresie.get(i).getCoeficient(), this.expresie.get(i).getGrad());
				rez.add(mon);
				i++;
			} else if (this.expresie.get(i).getGrad() < p2.expresie.get(j).getGrad()) {

				mon = new Monom(p2.expresie.get(j).getCoeficient(), p2.expresie.get(j).getGrad());
				rez.add(mon);
				j++;
			}

		}

		while (j < p2.expresie.size()) {
			mon = new Monom(p2.expresie.get(j).getCoeficient(), p2.expresie.get(j).getGrad());
			rez.add(mon);
			j++;
		}

		while (i < this.expresie.size()) {
			mon = new Monom(this.expresie.get(i).getCoeficient(), this.expresie.get(i).getGrad());
			rez.add(mon);
			i++;
		}
		Polinom p3 = new Polinom();
		p3.expresie = rez;

		return p3;

	}

	public Polinom polinomScadere(Polinom p2) {
		// 2x^100+2x^50
		Monom mon;
		int i = 0, j = 0;
		float coef;
		ArrayList<Monom> rez = new ArrayList<Monom>();

		while (i < this.expresie.size() && j < p2.expresie.size()) {

			if (this.expresie.get(i).getGrad() == p2.expresie.get(j).getGrad()) {

				coef = this.expresie.get(i).getCoeficient() - p2.expresie.get(j).getCoeficient();
				mon = new Monom(coef, this.expresie.get(i).getGrad());

				rez.add(mon);
				j++;
				i++;
			} else if (this.expresie.get(i).getGrad() > p2.expresie.get(j).getGrad()) {

				mon = new Monom(this.expresie.get(i).getCoeficient(), this.expresie.get(i).getGrad());
				rez.add(mon);
				i++;
			} else if (this.expresie.get(i).getGrad() < p2.expresie.get(j).getGrad()) {

				mon = new Monom(p2.expresie.get(j).getCoeficient() * (-1), p2.expresie.get(j).getGrad());
				rez.add(mon);
				j++;
			}

		}

		while (j < p2.expresie.size()) {
			mon = new Monom(p2.expresie.get(j).getCoeficient() * (-1), p2.expresie.get(j).getGrad());
			rez.add(mon);
			j++;
		}

		while (i < this.expresie.size()) {
			mon = new Monom(this.expresie.get(i).getCoeficient(), this.expresie.get(i).getGrad());
			rez.add(mon);
			i++;
		}
		Polinom p3 = new Polinom();
		p3.expresie = rez;

		return p3;

	}

	public Polinom polinomDerivata() {

		Monom mon;
		int i = 0, exp;
		float coef;
		ArrayList<Monom> rez = new ArrayList<Monom>();

		while (i < this.expresie.size()) {

			coef = this.expresie.get(i).getCoeficient() * this.expresie.get(i).getGrad();
			exp = this.expresie.get(i).getGrad() - 1;
			mon = new Monom(coef, exp);
			rez.add(mon);
			i += 1;

		}

		Polinom p3 = new Polinom();
		p3.expresie = rez;

		return p3;

	}

	public Polinom polinomIntegrala() {

		Monom mon;
		int i = 0, exp;
		float coef;
		ArrayList<Monom> rez = new ArrayList<Monom>();

		while (i < this.expresie.size()) {

			exp = this.expresie.get(i).getGrad() + 1;
			coef = this.expresie.get(i).getCoeficient() / (float) exp;
			mon = new Monom(coef, exp);
			rez.add(mon);
			i += 1;

		}

		Polinom p3 = new Polinom();
		p3.expresie = rez;

		return p3;

	}


	public Polinom polinomInmultire(Polinom p2) {

		Monom mon;
		int i = 0, j = 0;
		float coef, exp;
		ArrayList<Monom> rez = new ArrayList<Monom>();

		float max = 0;
		int ct = 0;
		// 2x^100+2x^50
		while (i < this.expresie.size()) {

			j = 0;

			while (j < p2.expresie.size()) {

				coef = this.expresie.get(i).getCoeficient() * p2.expresie.get(j).getCoeficient();
				exp = this.expresie.get(i).getGrad() + p2.expresie.get(j).getGrad();
				ct++;
				if (max < exp)
					max = exp;

				mon = new Monom(coef, (int) exp);
				rez.add(mon);

				j += 1;

			}

			i += 1;

		}

		Monom mono;

		ArrayList<Monom> f = new ArrayList<Monom>();
		float aux = 0;

		for (i = 0; i < rez.size(); i++) {
			// 2x^3+2x^2+2x^1+2x^0

			aux = rez.get(i).getCoeficient();

			for (j = i + 1; j < rez.size(); j++)
				if (rez.get(i).getGrad() == rez.get(j).getGrad() && rez.get(j).getGrad() != -1) {

					aux += rez.get(j).getCoeficient();
					rez.get(j).setGrad(-1);

				}

			if (rez.get(i).getGrad() != -1) {
				mono = new Monom(aux, rez.get(i).getGrad());
				f.add(mono);
			}
		}

		Polinom p3 = new Polinom();
		p3.expresie = f;

		return p3;

	}

}
