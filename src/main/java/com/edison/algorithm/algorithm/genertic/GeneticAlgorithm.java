package com.edison.algorithm.algorithm.genertic;

import java.util.Random;

/**
 * �Ŵ��㷨��
 * ������
 * 		1.run ��ʼ���㷨
 * 		2.createBeginningSpecies ������Ⱥ
 * 		3.calRate ����ÿһ�����ֱ�ѡ�еĸ���
 *      4.select  ���̲��� ѡ����Ӧ�ȸߵ�����
 *      5.crossover Ⱦɫ�彻��
 *      6.mutate Ⱦɫ�����
 *      7.getBest �����Ӧ����������
 */

public class GeneticAlgorithm {
	
	    //��ʼ�Ŵ�
		SpeciesIndividual run(SpeciesPopulation list)
		{
			//������ʼ��Ⱥ
			createBeginningSpecies(list);
			
			for(int i=1;i<=TSPData.DEVELOP_NUM;i++)
			{
				//ѡ��
				select(list);
				
				//����
				crossover(list);
				
				//����
				mutate(list);
			}	
			
			return getBest(list);
		}
		
		//������ʼ��Ⱥ
		void createBeginningSpecies(SpeciesPopulation list)
		{
			//100%���
			int randomNum=(int)(TSPData.SPECIES_NUM);
			for(int i=1;i<=randomNum;i++)
			{
				SpeciesIndividual species=new SpeciesIndividual();//�������
				species.createByRandomGenes();//��ʼ��Ⱥ����

				list.add(species);//�������
			}
			
//			//40%̰��
//			int greedyNum=TSPData.SPECIES_NUM-randomNum;
//			for(int i=1;i<=greedyNum;i++)
//			{
//				SpeciesIndividual species=new SpeciesIndividual();//�������
//				species.createByGreedyGenes();//��ʼ��Ⱥ����
	//
//				this.add(species);//�������
//			}
		}

		//����ÿһ���ֱ�ѡ�еĸ���
		void calRate(SpeciesPopulation list)
		{
			//��������Ӧ��
			float totalFitness=0.0f;
			list.speciesNum=0;
			SpeciesIndividual point=list.head.next;//�α�
			while(point != null)//Ѱ�ұ�β���
			{
				point.calFitness();//������Ӧ��
				
				totalFitness += point.fitness;
				list.speciesNum++;

				point=point.next;
			}

			//����ѡ�и���
			point=list.head.next;//�α�
			while(point != null)//Ѱ�ұ�β���
			{
				point.rate=point.fitness/totalFitness;
				point=point.next;
			}
		}
		
		//ѡ���������֣����̶ģ�
		void select(SpeciesPopulation list)
		{			
			//������Ӧ��
			calRate(list);
			
			//�ҳ������Ӧ������
			float talentDis=Float.MAX_VALUE;
			SpeciesIndividual talentSpecies=null;
			SpeciesIndividual point=list.head.next;//�α�

			while(point!=null)
			{
				if(talentDis > point.distance)
				{
					talentDis=point.distance;
					talentSpecies=point;
				}
				point=point.next;
			}

			//�������Ӧ�����ָ���talentNum��
			SpeciesPopulation newSpeciesPopulation=new SpeciesPopulation();
			int talentNum=(int)(list.speciesNum/4);
			for(int i=1;i<=talentNum;i++)
			{
				//�����������±�
				SpeciesIndividual newSpecies=talentSpecies.clone();
				newSpeciesPopulation.add(newSpecies);
			}

			//���̶�list.speciesNum-talentNum��
			int roundNum=list.speciesNum-talentNum;
			for(int i=1;i<=roundNum;i++)
			{
				//����0-1�ĸ���
				float rate=(float)Math.random();
				
				SpeciesIndividual oldPoint=list.head.next;//�α�
				while(oldPoint != null && oldPoint != talentSpecies)//Ѱ�ұ�β���
				{
					if(rate <= oldPoint.rate)
					{
						SpeciesIndividual newSpecies=oldPoint.clone();
						newSpeciesPopulation.add(newSpecies);
						
						break;
					}
					else
					{
						rate=rate-oldPoint.rate;
					}
					oldPoint=oldPoint.next;
				}
				if(oldPoint == null || oldPoint == talentSpecies)
				{
					//�������һ��
					point=list.head;//�α�
					while(point.next != null)//Ѱ�ұ�β���
						point=point.next;
					SpeciesIndividual newSpecies=point.clone();
					newSpeciesPopulation.add(newSpecies);
				}
				
			}
			list.head=newSpeciesPopulation.head;
		}
		
		//�������
		void crossover(SpeciesPopulation list)
		{
			//�Ը���pcl~pch����
			float rate=(float)Math.random();
			if(rate > TSPData.pcl && rate < TSPData.pch)
			{			
				SpeciesIndividual point=list.head.next;//�α�
				Random rand=new Random();
				int find=rand.nextInt(list.speciesNum);
				while(point != null && find != 0)//Ѱ�ұ�β���
				{
					point=point.next;
					find--;
				}
			
				if(point.next != null)
				{
					int begin=rand.nextInt(TSPData.CITY_NUM);

					//ȡpoint��point.next���н��棬�γ��µ�����Ⱦɫ��
					for(int i=begin;i<TSPData.CITY_NUM;i++)
					{
						//�ҳ�point.genes����point.next.genes[i]��ȵ�λ��fir
						//�ҳ�point.next.genes����point.genes[i]��ȵ�λ��sec
						int fir,sec;
						for(fir=0;!point.genes[fir].equals(point.next.genes[i]);fir++);
						for(sec=0;!point.next.genes[sec].equals(point.genes[i]);sec++);
						//�������򻥻�
						String tmp;
						tmp=point.genes[i];
						point.genes[i]=point.next.genes[i];
						point.next.genes[i]=tmp;
						
						//��ȥ�������ظ����Ǹ�����
						point.genes[fir]=point.next.genes[i];
						point.next.genes[sec]=point.genes[i];
						
					}
				}
			}
		}
		
		//�������
		void mutate(SpeciesPopulation list)
		{	
			//ÿһ���־��б���Ļ���,�Ը���pm����
			SpeciesIndividual point=list.head.next;
			while(point != null)
			{
				float rate=(float)Math.random();
				if(rate < TSPData.pm)
				{
					//Ѱ����ת���Ҷ˵�
					Random rand=new Random();
					int left=rand.nextInt(TSPData.CITY_NUM);
					int right=rand.nextInt(TSPData.CITY_NUM);
					if(left > right)
					{
						int tmp;
						tmp=left;
						left=right;
						right=tmp;
					}
					
					//��תleft-right�±�Ԫ��
					while(left < right)
					{
						String tmp;
						tmp=point.genes[left];
						point.genes[left]=point.genes[right];
						point.genes[right]=tmp;

						left++;
						right--;
					}
				}
				point=point.next;
			}
		}

		//�����Ӧ����������
		SpeciesIndividual getBest(SpeciesPopulation list)
		{
			float distance=Float.MAX_VALUE;
			SpeciesIndividual bestSpecies=null;
			SpeciesIndividual point=list.head.next;//�α�
			while(point != null)//Ѱ�ұ�β���
			{
				if(distance > point.distance)
				{
					bestSpecies=point;
					distance=point.distance;
				}

				point=point.next;
			}
			
			return bestSpecies;
		}

}
