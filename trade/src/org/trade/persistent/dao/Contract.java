/* ===========================================================
 * TradeManager : a application to trade strategies for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Project Info:  org.trade
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Oracle, Inc.
 * in the United States and other countries.]
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Original Author:  Simon Allen;
 * Contributor(s):   -;
 *
 * Changes
 * -------
 *
 */
package org.trade.persistent.dao;

// Generated Feb 21, 2011 12:43:33 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.trade.core.dao.Aspect;

/**
 * Contract generated by hbm2java
 * 
 * @author Simon Allen
 * @version $Revision: 1.0 $
 */
@Entity
@Table(name = "contract")
public class Contract extends Aspect implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5691902477608387034L;

	/*
	 * Contract
	 */
	@NotNull
	private String currency;
	private String comboLegDescription;
	@NotNull
	private String exchange;
	private Date expiry;
	private Integer idContractIB;
	private Boolean includeExpired;
	private String localSymbol;
	private BigDecimal priceMultiplier;
	private String primaryExchange; // pick a non-aggregate (ie not the SMART
									// exchange) exchange that the contract
									// trades on. DO NOT SET TO SMART.
	private String optionType; // P=Put, C=CALL
	@NotNull
	private String symbol;
	private String secId;
	private String secIdType; // CUSIP;SEDOL;ISIN;RIC
	@NotNull
	private String secType;
	private BigDecimal strike;
	private String tradingClass;

	/*
	 * Contract Details
	 */

	private String category;
	private String contractMonth;
	private String longName;
	private String industry;
	private String liquidHours;
	private String marketName;
	private String orderTypes;
	private BigDecimal minTick;
	private BigDecimal priceMagnifier;
	private String subCategory;
	private String timeZoneId;
	private String tradingHours;
	private Integer underConId;
	private String validExchanges;
	private String evRule;
	private BigDecimal evMultiplier;

	private BigDecimal lastAskPrice = new BigDecimal(0);
	private BigDecimal lastBidPrice = new BigDecimal(0);
	private BigDecimal lastPrice = new BigDecimal(0);

	private TradePosition tradePosition;
	private List<Tradestrategy> tradestrategies = Collections
			.synchronizedList(new ArrayList<Tradestrategy>(0));
	private List<TradePosition> tradePositions = new ArrayList<TradePosition>(0);
	private List<Candle> candles = new ArrayList<Candle>(0);

	public Contract() {
	}

	/**
	 * Constructor for Contract.
	 * 
	 * @param secType
	 *            String
	 * @param symbol
	 *            String
	 * @param exchange
	 *            String
	 * @param currency
	 *            String
	 * @param expiry
	 *            Date
	 */
	public Contract(String secType, String symbol, String exchange,
			String currency, Date expiry, BigDecimal priceMultiplier) {
		this.currency = currency;
		this.exchange = exchange;
		this.symbol = symbol;
		this.secType = secType;
		this.expiry = expiry;
		this.priceMultiplier = priceMultiplier;
	}

	/**
	 * Method getIdContract.
	 * 
	 * @return Integer
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idContract", unique = true, nullable = false)
	public Integer getIdContract() {
		return this.id;
	}

	/**
	 * Method setIdContract.
	 * 
	 * @param idContract
	 *            Integer
	 */
	public void setIdContract(Integer idContract) {
		this.id = idContract;
	}

	/**
	 * Method getCategory.
	 * 
	 * @return String
	 */
	@Column(name = "category", length = 80)
	public String getCategory() {
		return this.category;
	}

	/**
	 * Method setCategory.
	 * 
	 * @param category
	 *            String
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Method getCurrency.
	 * 
	 * @return String
	 */
	@Column(name = "currency", nullable = false, length = 3)
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Method setCurrency.
	 * 
	 * @param currency
	 *            String
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Method getComboLegDescription.
	 * 
	 * @return String
	 */
	@Column(name = "comboLegDescription", nullable = false, length = 30)
	public String getComboLegDescription() {
		return this.comboLegDescription;
	}

	/**
	 * Method setComboLegDescription.
	 * 
	 * @param comboLegDescription
	 *            String
	 */
	public void setComboLegDescription(String comboLegDescription) {
		this.comboLegDescription = comboLegDescription;
	}

	/**
	 * Method getContractMonth.
	 * 
	 * @return String
	 */
	@Column(name = "contractMonth", length = 6)
	public String getContractMonth() {
		return this.contractMonth;
	}

	/**
	 * Method setContractMonth.
	 * 
	 * @param contractMonth
	 *            String
	 */
	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
	}

	/**
	 * Method getLongName.
	 * 
	 * @return String
	 */
	@Column(name = "longName", length = 80)
	public String getLongName() {
		return this.longName;
	}

	/**
	 * Method setLongName.
	 * 
	 * @param longName
	 *            String
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}

	/**
	 * Method getEvMultiplier.
	 * 
	 * @return BigDecimal
	 */
	@Column(name = "evMultiplier", precision = 10)
	public BigDecimal getEvMultiplier() {
		return this.evMultiplier;
	}

	/**
	 * Method setEvMultiplier.
	 * 
	 * @param evMultiplier
	 *            BigDecimal
	 */
	public void setEvMultiplier(BigDecimal evMultiplier) {
		this.evMultiplier = evMultiplier;
	}

	/**
	 * Method getEvRule.
	 * 
	 * @return String
	 */
	@Column(name = "evRule", length = 80)
	public String getEvRule() {
		return this.evRule;
	}

	/**
	 * Method setEvRule.
	 * 
	 * @param evRule
	 *            String
	 */
	public void setEvRule(String evRule) {
		this.evRule = evRule;
	}

	/**
	 * Method getExchange.
	 * 
	 * @return String
	 */
	@Column(name = "exchange", nullable = false, length = 30)
	public String getExchange() {
		return this.exchange;
	}

	/**
	 * Method setExchange.
	 * 
	 * @param exchange
	 *            String
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	/**
	 * Method getExpiry.
	 * 
	 * @return Date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiry", unique = true, nullable = false, length = 19)
	public Date getExpiry() {
		return this.expiry;
	}

	/**
	 * Method setExpiry.
	 * 
	 * @param expiry
	 *            Date
	 */
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	/**
	 * Method getIdContractIB.
	 * 
	 * @return Integer
	 */
	@Column(name = "idContractIB")
	public Integer getIdContractIB() {
		return this.idContractIB;
	}

	/**
	 * Method setIdContractIB.
	 * 
	 * @param idContractIB
	 *            Integer
	 */
	public void setIdContractIB(Integer idContractIB) {
		this.idContractIB = idContractIB;
	}

	/**
	 * Method getIncludeExpired.
	 * 
	 * @return Boolean
	 */
	@Column(name = "includeExpired")
	public Boolean getIncludeExpired() {
		return this.includeExpired;
	}

	/**
	 * Method setIncludeExpired.
	 * 
	 * @param includeExpired
	 *            Boolean
	 */
	public void setIncludeExpired(Boolean includeExpired) {
		this.includeExpired = includeExpired;
	}

	/**
	 * Method getIndustry.
	 * 
	 * @return String
	 */
	@Column(name = "industry", length = 80)
	public String getIndustry() {
		return this.industry;
	}

	/**
	 * Method setIndustry.
	 * 
	 * @param industry
	 *            String
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * Method getLiquidHours.
	 * 
	 * @return String
	 */
	@Column(name = "liquidHours", length = 50)
	public String getLiquidHours() {
		return this.liquidHours;
	}

	/**
	 * Method setLiquidHours.
	 * 
	 * @param liquidHours
	 *            String
	 */
	public void setLiquidHours(String liquidHours) {
		this.liquidHours = liquidHours;
	}

	/**
	 * Method getLastPrice.
	 * 
	 * @return BigDecimal
	 */
	@Transient
	public BigDecimal getLastPrice() {
		return this.lastPrice;
	}

	/**
	 * Method setLastPrice.
	 * 
	 * @param lastPrice
	 *            BigDecimal
	 */
	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	/**
	 * Method getLastAskPrice.
	 * 
	 * @return BigDecimal
	 */
	@Transient
	public BigDecimal getLastAskPrice() {
		return this.lastAskPrice;
	}

	/**
	 * Method setLastAskPrice.
	 * 
	 * @param lastAskPrice
	 *            BigDecimal
	 */
	public void setLastAskPrice(BigDecimal lastAskPrice) {
		this.lastAskPrice = lastAskPrice;
	}

	/**
	 * Method getLastBidPrice.
	 * 
	 * @return BigDecimal
	 */
	@Transient
	public BigDecimal getLastBidPrice() {
		return this.lastBidPrice;
	}

	/**
	 * Method setLastBidPrice.
	 * 
	 * @param lastBidPrice
	 *            BigDecimal
	 */
	public void setLastBidPrice(BigDecimal lastBidPrice) {
		this.lastBidPrice = lastBidPrice;
	}

	/**
	 * Method getLocalSymbol.
	 * 
	 * @return String
	 */
	@Column(name = "localSymbol", length = 10)
	public String getLocalSymbol() {
		return this.localSymbol;
	}

	/**
	 * Method setLocalSymbol.
	 * 
	 * @param localSymbol
	 *            String
	 */
	public void setLocalSymbol(String localSymbol) {
		this.localSymbol = localSymbol;
	}

	/**
	 * Method getMarketName.
	 * 
	 * @return String
	 */
	@Column(name = "marketName", length = 80)
	public String getMarketName() {
		return this.marketName;
	}

	/**
	 * Method setMarketName.
	 * 
	 * @param marketName
	 *            String
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	/**
	 * Method getMinTick.
	 * 
	 * @return BigDecimal
	 */
	@Column(name = "minTick", precision = 10)
	public BigDecimal getMinTick() {
		return this.minTick;
	}

	/**
	 * Method setMinTick.
	 * 
	 * @param minTick
	 *            BigDecimal
	 */
	public void setMinTick(BigDecimal minTick) {
		this.minTick = minTick;
	}

	/**
	 * Method getOrderTypes.
	 * 
	 * @return String
	 */
	@Column(name = "orderTypes", length = 50)
	public String getOrderTypes() {
		return this.orderTypes;
	}

	/**
	 * Method setOrderTypes.
	 * 
	 * @param orderTypes
	 *            String
	 */
	public void setOrderTypes(String orderTypes) {
		this.orderTypes = orderTypes;
	}

	/**
	 * Method getPriceMagnifier.
	 * 
	 * @return BigDecimal
	 */
	@Column(name = "priceMagnifier", precision = 10)
	public BigDecimal getPriceMagnifier() {
		return this.priceMagnifier;
	}

	/**
	 * Method setPriceMagnifier.
	 * 
	 * @param priceMagnifier
	 *            BigDecimal
	 */
	public void setPriceMagnifier(BigDecimal priceMagnifier) {
		this.priceMagnifier = priceMagnifier;
	}

	/**
	 * Method getPriceMultiplier.
	 * 
	 * @return BigDecimal
	 */
	@Column(name = "priceMultiplier", precision = 10)
	public BigDecimal getPriceMultiplier() {
		return this.priceMultiplier;
	}

	/**
	 * Method setPriceMultiplier.
	 * 
	 * @param priceMultiplier
	 *            BigDecimal
	 */
	public void setPriceMultiplier(BigDecimal priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}

	/**
	 * Method getPrimaryExchange.
	 * 
	 * @return String
	 */
	@Column(name = "primaryExchange", length = 10)
	public String getPrimaryExchange() {
		return this.primaryExchange;
	}

	/**
	 * Method setPrimaryExchange.
	 * 
	 * @param primaryExchange
	 *            String
	 */
	public void setPrimaryExchange(String primaryExchange) {
		this.primaryExchange = primaryExchange;
	}

	/**
	 * Method getOptionType .
	 * 
	 * @return optionType
	 */
	@Column(name = "optionType ", length = 1)
	public String getOptionType() {
		return this.optionType;
	}

	/**
	 * Method setOptionType.
	 * 
	 * @param optionType
	 *            String
	 */
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	/**
	 * Method getSymbol.
	 * 
	 * @return String
	 */
	@Column(name = "symbol", unique = true, nullable = false, length = 10)
	public String getSymbol() {
		return this.symbol;
	}

	/**
	 * Method setSymbol.
	 * 
	 * @param symbol
	 *            String
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Method getSecId.
	 * 
	 * @return String
	 */
	@Column(name = "secId", length = 10)
	public String getSecId() {
		return this.secId;
	}

	/**
	 * Method setSecId.
	 * 
	 * @param secId
	 *            String
	 */
	public void setSecId(String secId) {
		this.secId = secId;
	}

	/**
	 * Method getSecIdType.
	 * 
	 * @return String
	 */
	@Column(name = "secIdType", length = 5)
	public String getSecIdType() {
		return this.secIdType;
	}

	/**
	 * Method setSecIdType.
	 * 
	 * @param secIdType
	 *            String
	 */
	public void setSecIdType(String secIdType) {
		this.secIdType = secIdType;
	}

	/**
	 * Method getSecType.
	 * 
	 * @return String
	 */
	@Column(name = "secType", nullable = false, length = 4)
	public String getSecType() {
		return this.secType;
	}

	/**
	 * Method setSecType.
	 * 
	 * @param secType
	 *            String
	 */
	public void setSecType(String secType) {
		this.secType = secType;
	}

	/**
	 * Method getStrike.
	 * 
	 * @return BigDecimal
	 */
	@Column(name = "strike", precision = 10)
	public BigDecimal getStrike() {
		return this.strike;
	}

	/**
	 * Method setStrike.
	 * 
	 * @param strike
	 *            BigDecimal
	 */
	public void setStrike(BigDecimal strike) {
		this.strike = strike;
	}

	/**
	 * Method getSubCategory.
	 * 
	 * @return String
	 */
	@Column(name = "subCategory", length = 80)
	public String getSubCategory() {
		return this.subCategory;
	}

	/**
	 * Method setSubCategory.
	 * 
	 * @param subCategory
	 *            String
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * Method getTradingClass.
	 * 
	 * @return String
	 */
	@Column(name = "tradingClass", length = 80)
	public String getTradingClass() {
		return this.tradingClass;
	}

	/**
	 * Method setTradingClass.
	 * 
	 * @param tradingClass
	 *            String
	 */
	public void setTradingClass(String tradingClass) {
		this.tradingClass = tradingClass;
	}

	/**
	 * Method getTradingHours.
	 * 
	 * @return String
	 */
	@Column(name = "tradingHours", length = 100)
	public String getTradingHours() {
		return this.tradingHours;
	}

	/**
	 * Method setTradingHours.
	 * 
	 * @param tradingHours
	 *            String
	 */
	public void setTradingHours(String tradingHours) {
		this.tradingHours = tradingHours;
	}

	/**
	 * Method setTimeZoneId.
	 * 
	 * @param timeZoneId
	 *            String
	 */
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	/**
	 * Method getTimeZoneId.
	 * 
	 * @return String
	 */
	@Column(name = "timeZoneId", length = 7)
	public String getTimeZoneId() {
		return this.timeZoneId;
	}

	/**
	 * Method setUnderConId.
	 * 
	 * @param underConId
	 *            Integer
	 */
	public void setUnderConId(Integer underConId) {
		this.underConId = underConId;
	}

	/**
	 * Method getUnderConId.
	 * 
	 * @return Integer
	 */
	@Column(name = "underConId", length = 3)
	public Integer getUnderConId() {
		return this.underConId;
	}

	/**
	 * Method setValidExchanges.
	 * 
	 * @param validExchanges
	 *            String
	 */
	public void setValidExchanges(String validExchanges) {
		this.validExchanges = validExchanges;
	}

	/**
	 * Method getValidExchanges.
	 * 
	 * @return String
	 */
	@Column(name = "validExchanges", length = 200)
	public String getValidExchanges() {
		return this.validExchanges;
	}

	/**
	 * Method getVersion.
	 * 
	 * @return Integer
	 */
	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Method setVersion.
	 * 
	 * @param version
	 *            Integer
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Method addTradestrategy.
	 * 
	 * @param tradestrategy
	 *            Tradestrategy
	 */
	public void addTradestrategy(Tradestrategy tradestrategy) {
		this.tradestrategies.add(tradestrategy);
	}

	/**
	 * Method removeTradestrategies.
	 * 
	 * @param tradestrategy
	 *            Tradestrategy
	 */
	public boolean removeTradestrategy(Tradestrategy tradestrategy) {
		for (ListIterator<Tradestrategy> itemIter = this.tradestrategies
				.listIterator(); itemIter.hasNext();) {
			Tradestrategy item = itemIter.next();
			if (item.equals(tradestrategy)) {
				itemIter.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Method getTradestrategies.
	 * 
	 * Note this relationship is not used except in a local way to monitor
	 * tradestrategies that are submitted via the broker interface hence the use
	 * of Transient. This allows us to add to the collection.
	 * 
	 * @return List<Tradestrategy>
	 */
	// @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
	@Transient
	public List<Tradestrategy> getTradestrategies() {
		return this.tradestrategies;
	}

	/**
	 * Method setTradestrategies.
	 * 
	 * @param tradestrategies
	 *            List<Tradestrategy>
	 */
	public void setTradestrategies(List<Tradestrategy> tradestrategies) {
		this.tradestrategies = tradestrategies;
	}

	/**
	 * Method getTradePosition.
	 * 
	 * @return TradePosition
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTradePosition", insertable = false, updatable = true, nullable = true)
	public TradePosition getTradePosition() {
		return this.tradePosition;
	}

	/**
	 * Method setTradePosition.
	 * 
	 * @param tradePosition
	 *            TradePosition
	 */
	public void setTradePosition(TradePosition tradePosition) {
		this.tradePosition = tradePosition;
	}

	/**
	 * Method getTradePositions.
	 * 
	 * @return List<TradePosition>
	 */
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
	public List<TradePosition> getTradePositions() {
		return this.tradePositions;
	}

	/**
	 * Method setTradePositions.
	 * 
	 * @param tradePositions
	 *            List<TradePosition>
	 */
	public void setTradePositions(List<TradePosition> tradePositions) {
		this.tradePositions = tradePositions;
	}

	/**
	 * Method getCandles.
	 * 
	 * @return List<Candle>
	 */
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = {
			CascadeType.REFRESH, CascadeType.REMOVE })
	public List<Candle> getCandles() {
		return this.candles;
	}

	/**
	 * Method setCandles.
	 * 
	 * @param candles
	 *            List<Candle>
	 */
	public void setCandles(List<Candle> candles) {
		this.candles = candles;
	}

	/**
	 * Method addTradePosition.
	 * 
	 * @param tradePosition
	 *            TradePosition
	 */
	public void addTradePosition(TradePosition tradePosition) {
		int index = 0;
		for (TradePosition currTradePosition : this.tradePositions) {
			if (currTradePosition.getIdTradePosition().equals(
					tradePosition.getIdTradePosition())) {
				index = this.tradePositions.indexOf(currTradePosition);
				break;
			}
		}
		if (index > 0)
			this.tradePositions.remove(index);

		this.tradePositions.add(tradePosition);
	}

	/**
	 * Method equals.
	 * 
	 * @param objectToCompare
	 *            Object
	 * @return boolean
	 */
	public boolean equals(Object objectToCompare) {

		if (super.equals(objectToCompare))
			return true;

		if (objectToCompare instanceof Contract) {
			Contract contract = (Contract) objectToCompare;
			if (this.getSymbol().equals(contract.getSymbol())) {
				if (this.getSecType().equals(contract.getSecType())) {
					if (this.getExchange().equals(contract.getExchange())) {
						if (this.getCurrency().equals(contract.getCurrency())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Method clone.
	 * 
	 * @return Object
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException {

		Contract contract = (Contract) super.clone();
		List<Tradestrategy> tradestrategies = new ArrayList<Tradestrategy>(0);
		contract.setTradestrategies(tradestrategies);
		List<TradePosition> tradePositions = new ArrayList<TradePosition>(0);
		contract.setTradePositions(tradePositions);
		return contract;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	public String toString() {
		return getSymbol().toUpperCase();
	}
}
