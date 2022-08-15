#ifndef SWEETABSTRACTFACTORYUPDATED_H
#define SWEETABSTRACTFACTORYUPDATED_H

  #include <iostream>

    class Sweet {
    public:
        virtual void wrap() = 0;
        virtual ~Sweet() {};
    };

    class Barone : public Chocolate {
    public:
			virtual void print();
	};

    class Tex : public Chocolate {
    public:
			virtual void print();
	};


	class HardSweet :public Sweet {
    public:
		  HardSweet();
		  virtual void wrap();
    protected:
      virtual void print();  
      int id_;
      static int total_;
  };


  
  class FizzPop : public HardSweet {
    protected:
			virtual void print();
	};

  class Sparkle : public HardSweet {
    protected:
			virtual void print();
	};


  class Factory {
    public:
      virtual Chocolate* produceChocolate() = 0;
      virtual HardSweet* produceSweet() = 0;
      virtual ~Factory() {};
  };

  class BaroneSparkleFactory : public Factory {
    public:
		  Chocolate* produceChocolate();
		  HardSweet* produceSweet();
	};

  class TexFizzPopFactory : public Factory {
    public:
	  	Chocolate* produceChocolate();
  		HardSweet* produceSweet();
  };

#endif
