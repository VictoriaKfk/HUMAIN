package setDaysOffLimits;

public class DaysOffSetter {
		
		private boolean DaysOff = false; 
		private int maxNumDaysoff;
		private boolean AbsenceSick = false; 
		private int maxNumAbsenceSick;
		private boolean WorkfromHome = false; 
		private int maxNumWorkfromHome;
		private boolean FieldWorkDays = false; 
		private int maxNumFieldWorkDays;

		public DaysOffSetter() {
			super();
		
		}

		public boolean isDaysOff() {
			return DaysOff;
		}

		public void setDaysOff(boolean daysOff) {
			DaysOff = daysOff;
		}

		public int getMaxNumDaysoff() {
			return maxNumDaysoff;
		}

		public void setMaxNumDaysoff(int maxNumDaysoff) {
			this.maxNumDaysoff = maxNumDaysoff;
		}

		public boolean isSickDaysOff() {
			return AbsenceSick;
		}

		public void setSickDaysOff(boolean AbsenceSick) {
			this.AbsenceSick = AbsenceSick;
		}

		public int getMaxNumSickDaysoff() {
			return maxNumAbsenceSick;
		}

		public void setMaxNumSickDaysoff(int maxNumAbsenceSick) {
			this.maxNumAbsenceSick = maxNumAbsenceSick;
		}

		public boolean isWorkfromHomeDaysOff() {
			return WorkfromHome;
		}

		public void setWorkfromHomeDaysOff(boolean WorkfromHome) {
			this.WorkfromHome = WorkfromHome;
		}

		public int getMaxNumWorkfromHomeDaysOff() {
			return maxNumWorkfromHome;
		}

		public void setMaxNumWorkfromHomeDaysOff(int maxNumWorkfromHome) {
			this.maxNumWorkfromHome = maxNumWorkfromHome;
		}

		public boolean isFieldWorkDays() {
			return FieldWorkDays;
		}

		public void setFieldWorkDays(boolean fieldWorkDays) {
			FieldWorkDays = fieldWorkDays;
		}

		public int getMaxNumFieldWorkDays() {
			return maxNumFieldWorkDays;
		}

		public void setMaxNumFieldWorkDays(int maxNumFieldWorkDays) {
			this.maxNumFieldWorkDays = maxNumFieldWorkDays;
		}


}
