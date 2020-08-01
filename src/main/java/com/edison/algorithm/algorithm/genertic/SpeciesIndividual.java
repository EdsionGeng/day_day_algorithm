package com.edison.algorithm.algorithm.genertic;

import java.util.Random;

/**
 * ������
 * ������
 * 		1.createByRandomGenes ��ʼ���ֻ���(���) ����ֱ���ó������б���
 * 		2.calFitness ����������Ӧ��
 * 		3.printRate ��ӡ·��
 */

public class SpeciesIndividual {
	
	String[] genes;//��������
	float distance;//·��
	float fitness;//��Ӧ��
	SpeciesIndividual next;
	float rate;
	
	SpeciesIndividual()
	{
		//��ʼ��
		this.genes=new String[TSPData.CITY_NUM];
		this.fitness=0.0f;
		this.distance=0.0f;
		this.next=null;
		rate=0.0f;
	}
	
	//��ʼ���ֻ���(���)
	void createByRandomGenes()
	{
		//��ʼ������Ϊ1-CITY_NUM����
		for(int i = 0;i < genes.length;i++)
		{
			genes[i]=Integer.toString(i+1);
		}
		
		//��ȡ�������
		Random rand=new Random();

		for(int j=0;j<genes.length;j++)
		{
			int num= j + rand.nextInt(genes.length-j);
			
			//����
			String tmp;
			tmp=genes[num];
			genes[num]=genes[j];
			genes[j]=tmp;
		}
	}
	
	//��ʼ���ֻ���(̰��)
	void createByGreedyGenes()
	{
		Random rand=new Random();
		int i= rand.nextInt(TSPData.CITY_NUM); //�������һ��������Ϊ���
		genes[0]=Integer.toString(i+1);
		int j;//�յ�
		int cityNum=0;
		do
		{
			cityNum++;
			
			//ѡ����Դ��̳���
			float minDis=Integer.MAX_VALUE;
			int minCity=0;
			for(j=0;j<TSPData.CITY_NUM;j++)
			{
				if(j != i)
				{
					//���Ƿ�������ظ�
					boolean repeat=false;
					for(int n=0;n<cityNum;n++)
					{
						if(Integer.parseInt(genes[n]) == j+1)
						{
							repeat=true;//����
							break;
						}
					}
					if(repeat == false)//û��
					{
						//�г���
						if(TSPData.disMap[i][j] < minDis)
						{
							minDis=TSPData.disMap[i][j];
							minCity=j;
						}
					}
				}
			}
			
			//���뵽Ⱦɫ��
			genes[cityNum]=Integer.toString(minCity+1);
			i=minCity;
		}while(cityNum < TSPData.CITY_NUM-1);
	}
	
	//����������Ӧ��
	void calFitness()
	{
		float totalDis=0.0f;
		for(int i = 0;i < TSPData.CITY_NUM;i++)
		{
			int curCity=Integer.parseInt(this.genes[i])-1;
			int nextCity=Integer.parseInt(this.genes[(i+1) % TSPData.CITY_NUM])-1;

			totalDis += TSPData.disMap[curCity][nextCity];
		}
		
		this.distance=totalDis;
		this.fitness=1.0f/totalDis;
	}
	
	//���
	public SpeciesIndividual clone()
	{	
		SpeciesIndividual species=new SpeciesIndividual();
		
		//����ֵ
		for(int i=0;i<this.genes.length;i++)
			species.genes[i]=this.genes[i];
		species.distance=this.distance;
		species.fitness=this.fitness;
	
		return species;	
	}
	
	//��ӡ·��
	void printRate()
	{
		System.out.print("���·�ߣ�");
		for(int i=0;i<genes.length;i++)
			System.out.print(genes[i]+"->");
		System.out.print(genes[0]+"\n");
		System.out.print("��̳��ȣ�" + distance);
	}

}
