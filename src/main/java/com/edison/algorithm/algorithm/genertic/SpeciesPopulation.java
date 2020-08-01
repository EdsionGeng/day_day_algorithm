package com.edison.algorithm.algorithm.genertic;

/**
 * ��Ⱥ��
 * ������
 * 		1.add �������
 * 		2.traverse ����
 */

public class SpeciesPopulation {
	
	SpeciesIndividual head;//ͷ���
	int speciesNum;//��������
	
	SpeciesPopulation()
	{
		head=new SpeciesIndividual();
		speciesNum=TSPData.SPECIES_NUM;
	}
	
	//�������
	void add(SpeciesIndividual species)
	{
		SpeciesIndividual point=head;//�α�
		while(point.next != null)//Ѱ�ұ�β���
			point=point.next;
		point.next=species;
	}
	
	//����
	void traverse()
	{
		SpeciesIndividual point=head.next;//�α�
		while(point != null)//Ѱ�ұ�β���
		{
			for(int i=0;i<TSPData.CITY_NUM;i++)
				System.out.print(point.genes[i]+" ");
			System.out.println(point.distance);
			point=point.next;
		}
		System.out.println("_______________________");
	}

}
