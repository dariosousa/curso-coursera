package co.com.s4n.entregaralmuerzo.enumeration;

import co.com.s4n.entregaralmuerzo.bean.DronBean;

public enum Direccion {
	NA {
		public int calcular(DronBean dron){
			dron.setY(dron.getY()+1);
			return 0;
		}
	},
	ND{
		public int calcular(DronBean dron){
			dron.setDireccion("E");
			return 0;
		}
	},
	NI{
		public int calcular(DronBean dron){
			dron.setDireccion("O");
			return 0;
		}
	},

	SA {
		public int calcular(DronBean dron){
			dron.setY(dron.getY()-1);
			return 0;
		}
	},
	SD{
		public int calcular(DronBean dron){
			dron.setDireccion("O");
			return 0;
		}
	},
	SI{
		public int calcular(DronBean dron){
			dron.setDireccion("E");
			return 0;
		}
	},

	EA {
		public int calcular(DronBean dron){
			dron.setX(dron.getX()+1);
			return 0;
		}
	},
	ED{
		public int calcular(DronBean dron){
			dron.setDireccion("S");
			return 0;
		}
	},
	EI{
		public int calcular(DronBean dron){
			dron.setDireccion("N");
			return 0;
		}
	},

	OA {
		public int calcular(DronBean dron){
			dron.setX(dron.getX()-1);
			return 0;
		}
	},
	OD{
		public int calcular(DronBean dron){
			dron.setDireccion("N");
			return 0;
		}
	},
	OI{
		public int calcular(DronBean dron){
			dron.setDireccion("S");
			return 0;
		}
	};

	public abstract int calcular(DronBean dron);
}