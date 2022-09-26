package com.springstarter.springbasicv2.scope;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeProviderTest {

    @Test
    public void providerTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int cnt1 = clientBean1.logic();
        assertThat(cnt1).isEqualTo(1);


        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int cnt2 = clientBean2.logic();
        assertThat(cnt2).isEqualTo(1);

    }

    static class ClientBean{
//        @Autowired
//        private ApplicationContext ac;

//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

        public int logic(){
//            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
//            PrototypeBean prototypeBean = prototypeBeanObjectProvider.getObject();
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return  count;
        }
    }

    @Scope("protoype")
    static class PrototypeBean{
        private  int count =0;
        public void addCount(){
            count ++;
        }
        public int getCount(){
            return count;
        }

        @PostConstruct
        public  void init(){
            System.out.println("PrototypeBean.init"+ this);
        }

        @PreDestroy
        public  void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
