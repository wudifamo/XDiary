package com.k.xdiary.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public class WeatherBean {


	private List<HeWeather5Bean> HeWeather5;

	public List<HeWeather5Bean> getHeWeather5() {
		return HeWeather5;
	}

	public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
		this.HeWeather5 = HeWeather5;
	}

	public static class HeWeather5Bean {

		private AqiBean aqi;
		private BasicBean basic;
		private NowBean now;
		private String status;
		private SuggestionBean suggestion;
		private List<DailyForecastBean> daily_forecast;
		private List<HourlyForecastBean> hourly_forecast;

		public AqiBean getAqi() {
			return aqi;
		}

		public void setAqi(AqiBean aqi) {
			this.aqi = aqi;
		}

		public BasicBean getBasic() {
			return basic;
		}

		public void setBasic(BasicBean basic) {
			this.basic = basic;
		}

		public NowBean getNow() {
			return now;
		}

		public void setNow(NowBean now) {
			this.now = now;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public SuggestionBean getSuggestion() {
			return suggestion;
		}

		public void setSuggestion(SuggestionBean suggestion) {
			this.suggestion = suggestion;
		}

		public List<DailyForecastBean> getDaily_forecast() {
			return daily_forecast;
		}

		public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
			this.daily_forecast = daily_forecast;
		}

		public List<HourlyForecastBean> getHourly_forecast() {
			return hourly_forecast;
		}

		public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
			this.hourly_forecast = hourly_forecast;
		}

		public static class AqiBean {
			/**
			 * city : {"aqi":"66","co":"1","no2":"27","o3":"61","pm10":"70","pm25":"47","qlty":"良","so2":"23"}
			 */

			private CityBean city;

			public CityBean getCity() {
				return city;
			}

			public void setCity(CityBean city) {
				this.city = city;
			}

			public static class CityBean {
				/**
				 * aqi : 66
				 * co : 1
				 * no2 : 27
				 * o3 : 61
				 * pm10 : 70
				 * pm25 : 47
				 * qlty : 良
				 * so2 : 23
				 */

				private String aqi;
				private String co;
				private String no2;
				private String o3;
				private String pm10;
				private String pm25;
				private String qlty;
				private String so2;

				public String getAqi() {
					return aqi;
				}

				public void setAqi(String aqi) {
					this.aqi = aqi;
				}

				public String getCo() {
					return co;
				}

				public void setCo(String co) {
					this.co = co;
				}

				public String getNo2() {
					return no2;
				}

				public void setNo2(String no2) {
					this.no2 = no2;
				}

				public String getO3() {
					return o3;
				}

				public void setO3(String o3) {
					this.o3 = o3;
				}

				public String getPm10() {
					return pm10;
				}

				public void setPm10(String pm10) {
					this.pm10 = pm10;
				}

				public String getPm25() {
					return pm25;
				}

				public void setPm25(String pm25) {
					this.pm25 = pm25;
				}

				public String getQlty() {
					return qlty;
				}

				public void setQlty(String qlty) {
					this.qlty = qlty;
				}

				public String getSo2() {
					return so2;
				}

				public void setSo2(String so2) {
					this.so2 = so2;
				}
			}
		}

		public static class BasicBean {
			/**
			 * city : 杭州
			 * cnty : 中国
			 * id : CN101210101
			 * lat : 30.319000
			 * lon : 120.165000
			 * update : {"loc":"2016-12-15 12:52","utc":"2016-12-15 04:52"}
			 */

			private String city;
			private String cnty;
			private String id;
			private String lat;
			private String lon;
			private UpdateBean update;

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getCnty() {
				return cnty;
			}

			public void setCnty(String cnty) {
				this.cnty = cnty;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getLat() {
				return lat;
			}

			public void setLat(String lat) {
				this.lat = lat;
			}

			public String getLon() {
				return lon;
			}

			public void setLon(String lon) {
				this.lon = lon;
			}

			public UpdateBean getUpdate() {
				return update;
			}

			public void setUpdate(UpdateBean update) {
				this.update = update;
			}

			public static class UpdateBean {
				/**
				 * loc : 2016-12-15 12:52
				 * utc : 2016-12-15 04:52
				 */

				private String loc;
				private String utc;

				public String getLoc() {
					return loc;
				}

				public void setLoc(String loc) {
					this.loc = loc;
				}

				public String getUtc() {
					return utc;
				}

				public void setUtc(String utc) {
					this.utc = utc;
				}
			}
		}

		public static class NowBean {
			/**
			 * cond : {"code":"101","txt":"多云"}
			 * fl : 4
			 * hum : 41
			 * pcpn : 0
			 * pres : 1032
			 * tmp : 6
			 * vis : 10
			 * wind : {"deg":"320","dir":"东北风","sc":"5-6","spd":"29"}
			 */

			private CondBean cond;
			private String fl;
			private String hum;
			private String pcpn;
			private String pres;
			private String tmp;
			private String vis;
			private WindBean wind;

			public CondBean getCond() {
				return cond;
			}

			public void setCond(CondBean cond) {
				this.cond = cond;
			}

			public String getFl() {
				return fl;
			}

			public void setFl(String fl) {
				this.fl = fl;
			}

			public String getHum() {
				return hum;
			}

			public void setHum(String hum) {
				this.hum = hum;
			}

			public String getPcpn() {
				return pcpn;
			}

			public void setPcpn(String pcpn) {
				this.pcpn = pcpn;
			}

			public String getPres() {
				return pres;
			}

			public void setPres(String pres) {
				this.pres = pres;
			}

			public String getTmp() {
				return tmp;
			}

			public void setTmp(String tmp) {
				this.tmp = tmp;
			}

			public String getVis() {
				return vis;
			}

			public void setVis(String vis) {
				this.vis = vis;
			}

			public WindBean getWind() {
				return wind;
			}

			public void setWind(WindBean wind) {
				this.wind = wind;
			}

			public static class CondBean {
				/**
				 * code : 101
				 * txt : 多云
				 */

				private String code;
				private String txt;

				public String getCode() {
					return code;
				}

				public void setCode(String code) {
					this.code = code;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class WindBean {
				/**
				 * deg : 320
				 * dir : 东北风
				 * sc : 5-6
				 * spd : 29
				 */

				private String deg;
				private String dir;
				private String sc;
				private String spd;

				public String getDeg() {
					return deg;
				}

				public void setDeg(String deg) {
					this.deg = deg;
				}

				public String getDir() {
					return dir;
				}

				public void setDir(String dir) {
					this.dir = dir;
				}

				public String getSc() {
					return sc;
				}

				public void setSc(String sc) {
					this.sc = sc;
				}

				public String getSpd() {
					return spd;
				}

				public void setSpd(String spd) {
					this.spd = spd;
				}
			}
		}

		public static class SuggestionBean {
			/**
			 * air : {"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}
			 * comf : {"brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"}
			 * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
			 * drsg : {"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"}
			 * flu : {"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"}
			 * sport : {"brf":"较不宜","txt":"天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"}
			 * trav : {"brf":"一般","txt":"天空状况还是比较好的，但温度稍微有点低，且风稍大，会让您感觉些许凉意。外出请注意防风。"}
			 * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
			 */

			private AirBean air;
			private ComfBean comf;
			private CwBean cw;
			private DrsgBean drsg;
			private FluBean flu;
			private SportBean sport;
			private TravBean trav;
			private UvBean uv;

			public AirBean getAir() {
				return air;
			}

			public void setAir(AirBean air) {
				this.air = air;
			}

			public ComfBean getComf() {
				return comf;
			}

			public void setComf(ComfBean comf) {
				this.comf = comf;
			}

			public CwBean getCw() {
				return cw;
			}

			public void setCw(CwBean cw) {
				this.cw = cw;
			}

			public DrsgBean getDrsg() {
				return drsg;
			}

			public void setDrsg(DrsgBean drsg) {
				this.drsg = drsg;
			}

			public FluBean getFlu() {
				return flu;
			}

			public void setFlu(FluBean flu) {
				this.flu = flu;
			}

			public SportBean getSport() {
				return sport;
			}

			public void setSport(SportBean sport) {
				this.sport = sport;
			}

			public TravBean getTrav() {
				return trav;
			}

			public void setTrav(TravBean trav) {
				this.trav = trav;
			}

			public UvBean getUv() {
				return uv;
			}

			public void setUv(UvBean uv) {
				this.uv = uv;
			}

			public static class AirBean {
				/**
				 * brf : 良
				 * txt : 气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class ComfBean {
				/**
				 * brf : 较舒适
				 * txt : 白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class CwBean {
				/**
				 * brf : 较适宜
				 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class DrsgBean {
				/**
				 * brf : 冷
				 * txt : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class FluBean {
				/**
				 * brf : 较易发
				 * txt : 天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class SportBean {
				/**
				 * brf : 较不宜
				 * txt : 天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class TravBean {
				/**
				 * brf : 一般
				 * txt : 天空状况还是比较好的，但温度稍微有点低，且风稍大，会让您感觉些许凉意。外出请注意防风。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class UvBean {
				/**
				 * brf : 最弱
				 * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
				 */

				private String brf;
				private String txt;

				public String getBrf() {
					return brf;
				}

				public void setBrf(String brf) {
					this.brf = brf;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}
		}

		public static class DailyForecastBean {
			/**
			 * astro : {"mr":"18:35","ms":"07:39","sr":"06:48","ss":"17:00"}
			 * cond : {"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"}
			 * date : 2016-12-15
			 * hum : 67
			 * pcpn : 0.0
			 * pop : 0
			 * pres : 1033
			 * tmp : {"max":"8","min":"0"}
			 * uv : 4
			 * vis : 10
			 * wind : {"deg":"342","dir":"北风","sc":"3-4","spd":"15"}
			 */

			private AstroBean astro;
			private CondBeanX cond;
			private String date;
			private String hum;
			private String pcpn;
			private String pop;
			private String pres;
			private TmpBean tmp;
			private String uv;
			private String vis;
			private WindBeanX wind;

			public AstroBean getAstro() {
				return astro;
			}

			public void setAstro(AstroBean astro) {
				this.astro = astro;
			}

			public CondBeanX getCond() {
				return cond;
			}

			public void setCond(CondBeanX cond) {
				this.cond = cond;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getHum() {
				return hum;
			}

			public void setHum(String hum) {
				this.hum = hum;
			}

			public String getPcpn() {
				return pcpn;
			}

			public void setPcpn(String pcpn) {
				this.pcpn = pcpn;
			}

			public String getPop() {
				return pop;
			}

			public void setPop(String pop) {
				this.pop = pop;
			}

			public String getPres() {
				return pres;
			}

			public void setPres(String pres) {
				this.pres = pres;
			}

			public TmpBean getTmp() {
				return tmp;
			}

			public void setTmp(TmpBean tmp) {
				this.tmp = tmp;
			}

			public String getUv() {
				return uv;
			}

			public void setUv(String uv) {
				this.uv = uv;
			}

			public String getVis() {
				return vis;
			}

			public void setVis(String vis) {
				this.vis = vis;
			}

			public WindBeanX getWind() {
				return wind;
			}

			public void setWind(WindBeanX wind) {
				this.wind = wind;
			}

			public static class AstroBean {
				/**
				 * mr : 18:35
				 * ms : 07:39
				 * sr : 06:48
				 * ss : 17:00
				 */

				private String mr;
				private String ms;
				private String sr;
				private String ss;

				public String getMr() {
					return mr;
				}

				public void setMr(String mr) {
					this.mr = mr;
				}

				public String getMs() {
					return ms;
				}

				public void setMs(String ms) {
					this.ms = ms;
				}

				public String getSr() {
					return sr;
				}

				public void setSr(String sr) {
					this.sr = sr;
				}

				public String getSs() {
					return ss;
				}

				public void setSs(String ss) {
					this.ss = ss;
				}
			}

			public static class CondBeanX {
				/**
				 * code_d : 101
				 * code_n : 100
				 * txt_d : 多云
				 * txt_n : 晴
				 */

				private String code_d;
				private String code_n;
				private String txt_d;
				private String txt_n;

				public String getCode_d() {
					return code_d;
				}

				public void setCode_d(String code_d) {
					this.code_d = code_d;
				}

				public String getCode_n() {
					return code_n;
				}

				public void setCode_n(String code_n) {
					this.code_n = code_n;
				}

				public String getTxt_d() {
					return txt_d;
				}

				public void setTxt_d(String txt_d) {
					this.txt_d = txt_d;
				}

				public String getTxt_n() {
					return txt_n;
				}

				public void setTxt_n(String txt_n) {
					this.txt_n = txt_n;
				}
			}

			public static class TmpBean {
				/**
				 * max : 8
				 * min : 0
				 */

				private String max;
				private String min;

				public String getMax() {
					return max;
				}

				public void setMax(String max) {
					this.max = max;
				}

				public String getMin() {
					return min;
				}

				public void setMin(String min) {
					this.min = min;
				}
			}

			public static class WindBeanX {
				/**
				 * deg : 342
				 * dir : 北风
				 * sc : 3-4
				 * spd : 15
				 */

				private String deg;
				private String dir;
				private String sc;
				private String spd;

				public String getDeg() {
					return deg;
				}

				public void setDeg(String deg) {
					this.deg = deg;
				}

				public String getDir() {
					return dir;
				}

				public void setDir(String dir) {
					this.dir = dir;
				}

				public String getSc() {
					return sc;
				}

				public void setSc(String sc) {
					this.sc = sc;
				}

				public String getSpd() {
					return spd;
				}

				public void setSpd(String spd) {
					this.spd = spd;
				}
			}
		}

		public static class HourlyForecastBean {
			/**
			 * cond : {"code":"100","txt":"晴"}
			 * date : 2016-12-15 13:00
			 * hum : 47
			 * pop : 0
			 * pres : 1032
			 * tmp : 8
			 * wind : {"deg":"340","dir":"西北风","sc":"微风","spd":"16"}
			 */

			private CondBeanXX cond;
			private String date;
			private String hum;
			private String pop;
			private String pres;
			private String tmp;
			private WindBeanXX wind;

			public CondBeanXX getCond() {
				return cond;
			}

			public void setCond(CondBeanXX cond) {
				this.cond = cond;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getHum() {
				return hum;
			}

			public void setHum(String hum) {
				this.hum = hum;
			}

			public String getPop() {
				return pop;
			}

			public void setPop(String pop) {
				this.pop = pop;
			}

			public String getPres() {
				return pres;
			}

			public void setPres(String pres) {
				this.pres = pres;
			}

			public String getTmp() {
				return tmp;
			}

			public void setTmp(String tmp) {
				this.tmp = tmp;
			}

			public WindBeanXX getWind() {
				return wind;
			}

			public void setWind(WindBeanXX wind) {
				this.wind = wind;
			}

			public static class CondBeanXX {
				/**
				 * code : 100
				 * txt : 晴
				 */

				private String code;
				private String txt;

				public String getCode() {
					return code;
				}

				public void setCode(String code) {
					this.code = code;
				}

				public String getTxt() {
					return txt;
				}

				public void setTxt(String txt) {
					this.txt = txt;
				}
			}

			public static class WindBeanXX {
				/**
				 * deg : 340
				 * dir : 西北风
				 * sc : 微风
				 * spd : 16
				 */

				private String deg;
				private String dir;
				private String sc;
				private String spd;

				public String getDeg() {
					return deg;
				}

				public void setDeg(String deg) {
					this.deg = deg;
				}

				public String getDir() {
					return dir;
				}

				public void setDir(String dir) {
					this.dir = dir;
				}

				public String getSc() {
					return sc;
				}

				public void setSc(String sc) {
					this.sc = sc;
				}

				public String getSpd() {
					return spd;
				}

				public void setSpd(String spd) {
					this.spd = spd;
				}
			}
		}
	}
}
