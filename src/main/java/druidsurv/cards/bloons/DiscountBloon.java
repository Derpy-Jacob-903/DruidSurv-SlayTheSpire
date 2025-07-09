package druidsurv.cards.bloons;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.DISCOUNT;

public class DiscountBloon extends AbstractEasyCard {
    public final static String ID = makeID("DiscountBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DiscountBloon() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "DiscountBloon_CardArt");
        baseBlock = 5;
        baseDamage = 12;
        baseMagicNumber = magicNumber = 1;
        PersistFields.setBaseValue(this, 4);
        ExhaustiveVariable.setBaseValue(this, 4);
        tags.add(druidsurv.cards.cardvars.CardTags.DISCOUNT);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < AbstractDungeon.player.hand.size(); i++) {
            AbstractCard c = AbstractDungeon.player.hand.group.get(i);
            if (c.hasTag(DISCOUNT) && c == this)
            {
                if (c.cost > 0) {
                    c.cost--;
                    addToBot((AbstractGameAction)new LoseEnergyAction(1));
                }
                if (c.costForTurn > 0) {
                    c.costForTurn--;
                }
            }
        }
        addToBot((AbstractGameAction)new LoseEnergyAction(1)); //Above code discounts the played card.
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 2, damage, "Discount Bloon"), 1, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }
/*
    @Override
    public boolean atBattleStartPreDraw() {
        shuffleIn(new DiscountBloonC());
        shuffleIn(new DiscountBloonC());
        return true;
    }
*/

    @Override
    public void upp() {
        //upgradeMagicNumber(-2);
    }
}