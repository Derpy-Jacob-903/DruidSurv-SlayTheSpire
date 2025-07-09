package druidsurv.cards.democards.complex;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.LambdaPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelf;
import static druidsurv.util.Wiz.atb;

@AutoAdd.Ignore
public class InlinePowerDemo extends AbstractEasyCard {
    public final static String ID = makeID(InlinePowerDemo.class.getSimpleName());
    // intellij stuff power, self, uncommon

    public InlinePowerDemo() {
        super(ID, 1, CardType.POWER, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = magicNumber = 4;
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_power_hidden.png", "druidsurvResources/images/cardui/1024/frame_power_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("StrikeAndBlockBoostPower"), cardStrings.EXTENDED_DESCRIPTION[0], AbstractPower.PowerType.BUFF, false, p, magicNumber) {
            @Override
            public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card) {
                if (card.hasTag(CardTags.STRIKE)) {
                    return damage + amount;
                }
                if (card.hasTag(druidsurv.cards.cardvars.CardTags.DART)) {
                    return damage + amount;
                }
                return damage;
            }

            @Override
            public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
                flash();
                atb(new GainBlockAction(owner, amount));
            }

            @Override
            public void updateDescription() {
                description = cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
            }
        });
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}