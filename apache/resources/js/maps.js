var FPMaps = FP.defaultClass.extend({
	temp: 1,
	init: function(){
		this.teste();
	},
	setTeste:function(a){
		this.temp = a;
	},
	getTeste:function(){
		return this.temp;
	}
});