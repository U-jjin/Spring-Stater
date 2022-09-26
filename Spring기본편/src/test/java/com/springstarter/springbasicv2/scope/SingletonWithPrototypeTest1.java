package com.springstarter.springbasicv2.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    public void prototypeFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean1.addCount();
        assertThat(protoTypeBean1.getCount()).isEqualTo(1);

        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean2.addCount();
        assertThat(protoTypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    public void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,ProtoTypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int cnt1 = clientBean1.logic();
        assertThat(cnt1).isEqualTo(1);


        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int cnt2 = clientBean2.logic();
        assertThat(cnt2).isEqualTo(2);

    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientBean{
     private final ProtoTypeBean protoTypeBean;

     public int logic(){
         protoTypeBean.addCount();
         int count = protoTypeBean.getCount();
         return  count;
     }
    }

    @Scope("protoype")
    static class ProtoTypeBean{
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
