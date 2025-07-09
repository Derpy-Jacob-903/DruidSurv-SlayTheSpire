package druidsurv.cards.monkeys.magick;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.p;

public class BlueMage extends AbstractEasyCard {
    public final static String ID = makeID("BlueMage");
    int myMoxCount = 0;
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public BlueMage() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, CharacterFile.Enums.NEMDRUID_COLOR, "ArcaneMaster_CardArt");
        this.baseSecondMagic = 1;
        this.baseMagicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
        setOrbTexture("druidsurvResources/images/512/b_mox.png", "druidsurvResources/images/1024/b_mox.png");
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DrawCardAction( secondMagic ));
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        boolean hasMyMox = false;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).BlueAmount > 0)
                {
                    hasMyMox = true;
                }
            }
        }
        if (Objects.equals(card.cardID, this.cardID) ) { return hasMyMox && super.canPlay(card); }
        return super.canPlay(card);
    }
    public static int countCards() {
        int count = 0;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).BlueAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).BlueAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).RainAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RainAmount;
                }
            }
        }
        return count;
        }
    public void calculateCardDamage(AbstractMonster mo) {
        /*  70 */     int realBaseDamage = this.baseSecondMagic;
        /*  71 */     this.baseSecondMagic += this.magicNumber * countCards();
        /*  73 */     super.calculateCardDamage(mo);
        /*  75 */     this.baseSecondMagic = realBaseDamage;
        /*  78 */     this.isSecondMagicModified = (this.block != this.baseSecondMagic);
        /*     */   }
    /*     */   public void applyPowers() {
        /*  85 */     int realBaseDamage = this.baseSecondMagic;
        /*  86 */     this.baseSecondMagic += this.magicNumber * countCards();
        /*  88 */     super.applyPowers();
        /*  90 */     this.baseSecondMagic = realBaseDamage;
        /*  93 */     this.isSecondMagicModified = (this.block != this.baseSecondMagic);
        /*     */   }
    @Override
    public void upp() {
        upgradeDamage(3); upgradeMagicNumber(1);
    }
}